/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.daemon

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet
import org.jetbrains.kotlin.daemon.common.DummyProfiler
import org.jetbrains.kotlin.daemon.common.Profiler
import org.jetbrains.kotlin.daemon.common.withMeasure
import org.jetbrains.kotlin.incremental.components.*
import org.jetbrains.kotlin.incremental.components.LookupKind
import org.jetbrains.kotlin.utils.createStringInterner

class RemoteLookupTrackerClient(
    @Suppress("DEPRECATION") val facade: org.jetbrains.kotlin.daemon.common.CompilerCallbackServicesFacade,
    eventManager: EventManager,
    val profiler: Profiler = DummyProfiler()
) : LookupTracker {
    private val isDoNothing = profiler.withMeasure(this) { facade.lookupTracker_isDoNothing() }

    // Map: FileName -> (ScopeFqName -> Set<Pair<Name[String], LookupKind> | LookupInfo>)
    private val lookups = Object2ObjectOpenHashMap<String, MutableMap<String, MutableSet<Any>>>()
    private val interner = createStringInterner()

    override val requiresPosition: Boolean = profiler.withMeasure(this) { facade.lookupTracker_requiresPosition() }

    override fun record(filePath: String, position: Position, scopeFqName: String, scopeKind: ScopeKind, name: String, kind: LookupKind) {
        if (isDoNothing) return

        val internedSymbolFqName = interner.intern(scopeFqName)
        val internedName = interner.intern(name)

        val objectToPut: Any =
            if (requiresPosition)
                LookupInfo(filePath, position, scopeFqName, scopeKind, name, kind)
            else
                internedName to kind
        lookups.getOrPut(filePath, ::Object2ObjectOpenHashMap).getOrPut(internedSymbolFqName, ::ObjectOpenHashSet).add(objectToPut)
    }

    override fun clear() {
        lookups.clear()
    }

    init {
        eventManager.onCompilationFinished { flush() }
    }

    @Suppress("UNCHECKED_CAST")
    private fun flush() {
        if (isDoNothing || lookups.isEmpty()) return

        profiler.withMeasure(this) {
            facade.lookupTracker_record(
                lookups.flatMap { (filePath, lookupsByFile) ->
                    lookupsByFile.flatMap { (scopeFqName, lookupsByScopeFqName) ->
                        lookupsByScopeFqName.map { lookupInfoOrNameWithKind ->
                            if (requiresPosition)
                                lookupInfoOrNameWithKind as LookupInfo
                            else {
                                val (name, kind) = lookupInfoOrNameWithKind as Pair<String, LookupKind>
                                LookupInfo(
                                    filePath, Position.NO_POSITION, scopeFqName, ScopeKind.CLASSIFIER,
                                    name,
                                    kind
                                )
                            }
                        }
                    }
                }
            )
        }

        lookups.clear()
    }
}
