@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE")
package io.github.epicvon2468.cinterop

import kotlinx.cinterop.ExperimentalForeignApi
import kotlin.native.internal.NativePtr

actual typealias NativePointer = NativePtr// {

actual inline operator fun NativePointer.plus(offset: Long): NativePointer = this + offset

actual inline fun NativePointer.toLong(): Long = this.toLong()

//}

actual val NULL: NativePointer = NativePtr.NULL