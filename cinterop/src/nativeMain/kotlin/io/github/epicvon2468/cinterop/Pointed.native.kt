@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.cinterop

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.NativePointed

actual typealias NativePointed = NativePointed// {

actual inline val NativePointed?.rawPtr: NativePointer get() = this?.rawPtr ?: NULL

//}