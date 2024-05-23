/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir

import org.jetbrains.kotlin.KtSourceElement
import org.jetbrains.kotlin.fir.resolve.calls.AbstractCallInfo
import org.jetbrains.kotlin.fir.symbols.impl.FirCallableSymbol
import org.jetbrains.kotlin.fir.symbols.impl.FirConstructorSymbol
import org.jetbrains.kotlin.fir.types.*
import org.jetbrains.kotlin.incremental.components.LookupKind
import org.jetbrains.kotlin.name.ClassId
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.name.SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT
import org.jetbrains.kotlin.name.StandardClassIds
import org.jetbrains.kotlin.utils.SmartList

abstract class FirLookupTrackerComponent : FirSessionComponent {

    abstract fun recordLookup(name: String, inScopes: Iterable<String>, source: KtSourceElement?, fileSource: KtSourceElement?, kind: LookupKind)

    abstract fun recordLookup(name: String, inScope: String, source: KtSourceElement?, fileSource: KtSourceElement?, kind: LookupKind)
}

fun FirLookupTrackerComponent.recordCallLookup(callInfo: AbstractCallInfo, inType: ConeKotlinType) {
    val classId = inType.classId ?: return
    if (classId.isLocal) return
    val scopes = SmartList(classId.asFqNameString())
    if (classId.shortClassName == DEFAULT_NAME_FOR_COMPANION_OBJECT) {
        classId.outerClassId?.asFqNameString()?.also {
            scopes.add(it)
        }
    }
    recordNameLookup(callInfo.name, scopes, callInfo.callSite.source, callInfo.containingFile.source)
}

fun FirLookupTrackerComponent.recordCallLookup(callInfo: AbstractCallInfo, inScopes: Iterable<String>) {
    recordNameLookup(callInfo.name, inScopes, callInfo.callSite.source, callInfo.containingFile.source)
}

fun FirLookupTrackerComponent.recordTypeLookup(classId: ClassId, source: KtSourceElement?, fileSource: KtSourceElement?) {
    recordClassLikeLookup(classId, source, fileSource, LookupKind.TYPE)

}

fun FirLookupTrackerComponent.recordConstructorLikeLookup(classId: ClassId, source: KtSourceElement?, fileSource: KtSourceElement?) {
    recordClassLikeLookup(classId, source, fileSource, LookupKind.NAME)
}

private fun FirLookupTrackerComponent.recordClassLikeLookup(classId: ClassId, source: KtSourceElement?, fileSource: KtSourceElement?, kind: LookupKind) {
    if (!classId.isLocal && classId !in StandardClassIds.allBuiltinTypes) {
        val classFqName = classId.asSingleFqName()
        recordLookup(classFqName.shortName().asString(), classFqName.parent().asString(), source, fileSource, kind)
    }
}

fun FirLookupTrackerComponent.recordCompanionLookup(classId: ClassId, source: KtSourceElement?, fileSource: KtSourceElement?) {
    if (!classId.isLocal && classId !in StandardClassIds.allBuiltinTypes) {
        val classFqName = classId.asSingleFqName()
        recordLookup(classFqName.shortName().asString(), classFqName.parent().asString(), source, fileSource, LookupKind.NAME)
        recordLookup(
            classFqName.parent().shortName().asString(),
            classFqName.parent().parent().asString(),
            source, fileSource, LookupKind.NAME
        )
    }
}

fun FirLookupTrackerComponent.recordClassMemberLookup(
    memberName: String, classId: ClassId, source: KtSourceElement?, fileSource: KtSourceElement?
) {
    recordLookup(memberName, classId.asFqNameString(), source, fileSource, LookupKind.NAME)
}

fun FirLookupTrackerComponent.recordFqNameLookup(fqName: FqName, source: KtSourceElement?, fileSource: KtSourceElement?) {
    recordLookup(fqName.shortName().asString(), fqName.parent().asString(), source, fileSource, LookupKind.NAME)
}

fun FirLookupTrackerComponent.recordNameLookup(
    name: Name, inScopes: Iterable<String>, source: KtSourceElement?, fileSource: KtSourceElement?
) {
    recordLookup(name.asString(), inScopes, source, fileSource, LookupKind.NAME)
}

fun FirLookupTrackerComponent.recordNameLookup(name: Name, inScope: String, source: KtSourceElement?, fileSource: KtSourceElement?) {
    recordLookup(name.asString(), inScope, source, fileSource, LookupKind.NAME)
}

fun FirLookupTrackerComponent.recordTypeResolveAsLookup(typeRef: FirTypeRef, source: KtSourceElement?, fileSource: KtSourceElement?) {
    if (typeRef !is FirResolvedTypeRef) return // TODO: check if this is the correct behavior
    recordTypeResolveAsLookup(typeRef.type, source, fileSource, LookupKind.TYPE)
}

fun FirLookupTrackerComponent.recordUserTypeRefLookup(typeRef: FirUserTypeRef, inScopes: Iterable<String>, fileSource: KtSourceElement?) {
    inScopes.forEach { scope ->
        typeRef.qualifier.fold(FqName(scope)) { result, suffix ->
            recordLookup(suffix.name.asString(), result.asString(), typeRef.source, fileSource, LookupKind.TYPE)
            result.child(suffix.name)
        }
    }
}

fun FirLookupTrackerComponent.recordTypeResolveAsLookup(type: ConeKotlinType?, source: KtSourceElement?, fileSource: KtSourceElement?) {
    recordTypeResolveAsLookup(type, source, fileSource, LookupKind.TYPE)
}

fun FirLookupTrackerComponent.recordTypeConstructorResolveAsLookup(type: ConeKotlinType?, source: KtSourceElement?, fileSource: KtSourceElement?) {
    recordTypeResolveAsLookup(type, source, fileSource, LookupKind.NAME)
}

fun FirLookupTrackerComponent.recordTypeExhaustivenessResolveAsLookup(type: ConeKotlinType?, source: KtSourceElement?, fileSource: KtSourceElement?) {
    recordTypeResolveAsLookup(type, source, fileSource, LookupKind.EXHAUSTIVENESS)
}

// TODO: review all places that record resolved type as lookup and consider minimize the number of them; see #KT-66366
private fun FirLookupTrackerComponent.recordTypeResolveAsLookup(type: ConeKotlinType?, source: KtSourceElement?, fileSource: KtSourceElement?, kind: LookupKind) {
    if (type == null) return
    if (source == null && fileSource == null) return // TODO: investigate all cases
    if (type is ConeErrorType) return // TODO: investigate whether some cases should be recorded, e.g. unresolved
    type.classId?.let { classId ->
        recordClassLikeLookup(classId, source, fileSource, kind)
    }
    type.typeArguments.forEach {
        if (it is ConeKotlinType) recordTypeResolveAsLookup(it, source, fileSource, LookupKind.TYPE)
    }
}

fun FirLookupTrackerComponent.recordCallableCandidateAsLookup(
    callableSymbol: FirCallableSymbol<*>, source: KtSourceElement?, fileSource: KtSourceElement?
) {
    if (!callableSymbol.callableId.isLocal && callableSymbol !is FirConstructorSymbol) {
        recordTypeResolveAsLookup(callableSymbol.fir.returnTypeRef, source, fileSource)
        recordFqNameLookup(callableSymbol.callableId.asSingleFqName(), source, fileSource)
    }
}

val FirSession.lookupTracker: FirLookupTrackerComponent? by FirSession.nullableSessionComponentAccessor()
