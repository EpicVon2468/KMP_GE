@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.kmp_ge.core.interop

import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi

actual typealias Ptd = CPointed

actual typealias Ptr<T> = CPointer<T>

@Suppress("NOTHING_TO_INLINE")
actual inline fun exitProcess(status: Int): Nothing = kotlin.system.exitProcess(status)

actual const val EXIT_SUCCESS: Int = platform.posix.EXIT_SUCCESS

actual const val EXIT_FAILURE: Int = platform.posix.EXIT_FAILURE