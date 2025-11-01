@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE")
package io.github.epicvon2468.kmp_ge.core.interop

import kotlinx.cinterop.NativeFreeablePlacement
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.NativePlacement
import kotlinx.cinterop.allocPointerTo
import kotlinx.cinterop.NativePointed
import kotlinx.cinterop.CPointerVarOf
import kotlinx.cinterop.nativeHeap
import kotlinx.cinterop.CVariable
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.pointed
import kotlinx.cinterop.alloc
import kotlinx.cinterop.value
import kotlinx.cinterop.free
import kotlinx.cinterop.ptr

actual typealias NPtd = NativePointed

actual typealias Ptd = CPointed

actual inline val <T : Ptd> T.ptr: Ptr<T> get() = this.ptr

actual inline val <reified T : Ptd> Ptr<T>.pointed: T get() = this.pointed

actual typealias Var = CVariable

// START POINTER VARS

actual typealias PtrVarOf<T> = CPointerVarOf<T>

actual typealias Ptr<T> = CPointer<T>

actual inline var <P : Ptr<*>> PtrVarOf<P>.value: P?
	get() = this.value
	set(value) { this.value = value }

actual inline val <reified T : Ptd, reified P : Ptr<T>> PtrVarOf<P>.pointed: T? get() = this.pointed

// END POINTER VARS

actual typealias Mem = NativePlacement

actual typealias FMem = NativeFreeablePlacement

actual inline fun Mem.alloc(size: Long, align: Int): NPtd = this.alloc(size, align)

actual inline fun <reified T : Var> Mem.alloc(): T = this.alloc()

actual inline fun <T : Ptd> Mem.allocPtrTo(): PtrVarOf<Ptr<T>> = this.allocPointerTo()

actual inline fun FMem.free(ptr: Ptr<*>): Unit = this.free(ptr)

actual inline fun FMem.free(ptr: NPtd): Unit = this.free(ptr)

actual typealias HMem = nativeHeap

actual inline fun exitProcess(status: Int): Nothing = kotlin.system.exitProcess(status)

actual const val EXIT_SUCCESS: Int = platform.posix.EXIT_SUCCESS

actual const val EXIT_FAILURE: Int = platform.posix.EXIT_FAILURE