/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.name

enum class LookupKind(val descriptor: Int) {
    NAME(0),
    TYPE(1),
    EXHAUSTIVENESS(2),
    ;

    companion object {
        fun byDescriptorOrError(descriptor: Int): LookupKind = when (descriptor) {
            NAME.descriptor -> NAME
            TYPE.descriptor -> TYPE
            EXHAUSTIVENESS.descriptor -> EXHAUSTIVENESS
            else -> throw IllegalArgumentException("unknown LookupKind descriptor $descriptor",)
        }
    }
}