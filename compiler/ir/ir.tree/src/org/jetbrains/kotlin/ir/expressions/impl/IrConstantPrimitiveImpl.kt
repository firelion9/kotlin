/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.expressions.impl

import org.jetbrains.kotlin.ir.declarations.IrAttributeContainer
import org.jetbrains.kotlin.ir.expressions.IrConst
import org.jetbrains.kotlin.ir.expressions.IrConstantPrimitive
import org.jetbrains.kotlin.ir.util.IrElementConstructorIndicator

class IrConstantPrimitiveImpl internal constructor(
    @Suppress("UNUSED_PARAMETER")
    constructorIndicator: IrElementConstructorIndicator?,
    override val startOffset: Int,
    override val endOffset: Int,
    override var value: IrConst<*>,
) : IrConstantPrimitive() {
    override var attributeOwnerId: IrAttributeContainer = this
    override var originalBeforeInline: IrAttributeContainer? = null
    override var type = value.type
}

fun IrConstantPrimitiveImpl(
    startOffset: Int,
    endOffset: Int,
    value: IrConst<*>,
) = IrConstantPrimitiveImpl(
    constructorIndicator = null,
    startOffset = startOffset,
    endOffset = endOffset,
    value = value,
)
