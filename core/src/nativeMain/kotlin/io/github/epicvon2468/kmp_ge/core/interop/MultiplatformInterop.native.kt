@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE")
package io.github.epicvon2468.kmp_ge.core.interop

import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CVariable
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.NativeFreeablePlacement
import kotlinx.cinterop.NativePlacement
import kotlinx.cinterop.NativePointed
import kotlinx.cinterop.nativeHeap
import kotlinx.cinterop.alloc
import kotlinx.cinterop.free

actual typealias NPtd = NativePointed

actual typealias Ptd = CPointed

actual typealias Var = CVariable

actual typealias Ptr<T> = CPointer<T>

actual typealias Mem = NativePlacement

actual typealias FMem = NativeFreeablePlacement

actual inline fun Mem.alloc(size: Long, align: Int): NPtd = this.alloc(size, align)

actual inline fun <reified T : Var> Mem.alloc(): T = this.alloc()

actual inline fun FMem.free(ptr: Ptr<*>): Unit = this.free(ptr)

actual inline fun FMem.free(ptr: NPtd): Unit = this.free(ptr)

actual typealias HMem = nativeHeap

actual inline fun exitProcess(status: Int): Nothing = kotlin.system.exitProcess(status)

actual const val EXIT_SUCCESS: Int = platform.posix.EXIT_SUCCESS

actual const val EXIT_FAILURE: Int = platform.posix.EXIT_FAILURE