/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.incremental.utils

import com.intellij.util.containers.Interner
import org.jetbrains.kotlin.incremental.LookupSymbol
import org.jetbrains.kotlin.incremental.components.*
import org.jetbrains.kotlin.incremental.components.LookupKind

class TestLookupTracker(val savedLookups: MutableSet<LookupSymbol> = mutableSetOf()) : LookupTracker {
    val lookups = arrayListOf<LookupInfo>()
    private val interner = Interner.createStringInterner()

    override val requiresPosition: Boolean
        get() = true

    override fun record(filePath: String, position: Position, scopeFqName: String, scopeKind: ScopeKind, name: String, kind: LookupKind) {
        val internedFilePath = interner.intern(filePath)
        val internedScopeFqName = interner.intern(scopeFqName)
        val internedName = interner.intern(name)

        lookups.add(LookupInfo(internedFilePath, position, internedScopeFqName, scopeKind, internedName, kind))
    }

    override fun clear() {
        lookups.clear()
    }
}
