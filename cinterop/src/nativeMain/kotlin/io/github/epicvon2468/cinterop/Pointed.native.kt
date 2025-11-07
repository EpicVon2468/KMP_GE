@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.cinterop

import kotlinx.cinterop.interpretNullablePointed
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.NativePointed

actual typealias NativePointed = NativePointed// {

actual inline val NativePointed?.rawPtr: NativePointer get() = this?.rawPtr ?: NULL

//}

actual inline fun <reified T : NativePointed> interpretNullablePointed(pointer: NativePointer): T? = interpretNullablePointed(pointer)