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

package org.jetbrains.kotlin.incremental.storage

import org.jetbrains.kotlin.name.LookupKind

data class LookupSymbolKey(val nameHash: Int, val scopeHash: Int, val name:String, val scope:String, val kind:LookupKind) : Comparable<LookupSymbolKey> {
    constructor(name: String, scope: String, kind: LookupKind) : this(name.hashCode(), scope.hashCode(), name, scope, kind)

    override fun compareTo(other: LookupSymbolKey): Int {
        val nameCmp = nameHash.compareTo(other.nameHash)
        if (nameCmp != 0) return nameCmp

        val scopeCmp = scopeHash.compareTo(other.scopeHash)
        if (scopeCmp != 0) return scopeCmp

        return kind.compareTo(other.kind)
    }

    override fun hashCode(): Int {
        var result = nameHash
        result = 31 * result + scopeHash
        result = 31 * result + kind.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LookupSymbolKey

        if (nameHash != other.nameHash) return false
        if (scopeHash != other.scopeHash) return false
        if (kind != other.kind) return false

        return true
    }


}

data class ProtoMapValue(val isPackageFacade: Boolean, val bytes: ByteArray, val strings: Array<String>)
