@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE", "FINAL_UPPER_BOUND")
package io.github.epicvon2468.kmp_ge.core.interop

import kotlin.native.internal.NativePtr

import kotlinx.cinterop.NativeFreeablePlacement
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.NativePlacement
import kotlinx.cinterop.allocPointerTo
import kotlinx.cinterop.nativeNullPtr
import kotlinx.cinterop.NativePointed
import kotlinx.cinterop.CPointerVarOf
import kotlinx.cinterop.allocArrayOf
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.nativeHeap
import kotlinx.cinterop.toCPointer
import kotlinx.cinterop.CValuesRef
import kotlinx.cinterop.CVariable
import kotlinx.cinterop.toKString
import kotlinx.cinterop.rawValue
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.pointed
import kotlinx.cinterop.alignOf
import kotlinx.cinterop.sizeOf
import kotlinx.cinterop.toLong
import kotlinx.cinterop.alloc
import kotlinx.cinterop.value
import kotlinx.cinterop.refTo
import kotlinx.cinterop.free
import kotlinx.cinterop.plus
import kotlinx.cinterop.get
import kotlinx.cinterop.ptr

actual typealias NPtd = NativePointed

actual typealias Ptd = CPointed

actual typealias NPtr = NativePtr

actual inline val <T : Ptd> T.ptr: Ptr<T> get() = this.ptr

actual inline val <reified T : Ptd> Ptr<T>.pointed: T get() = this.pointed

actual inline operator fun <reified T : Var> Ptr<T>.get(index: Long): T = this[index]

actual inline operator fun <reified T : PtrVarOf<*>> Ptr<T>?.plus(index: Long): Ptr<T>? = this + index

actual val NULL: NPtr = nativeNullPtr

actual inline val Ptr<*>?.rawValue: NPtr get() = this.rawValue

actual inline fun <T : Ptd> Ptr<*>.reinterpret(): Ptr<T> = this.reinterpret()

actual inline fun <T : Ptd> Ptr<T>?.toLong(): Long = this.toLong()

actual inline fun <T : Ptd> Long.toPtr(): Ptr<T>? = this.toCPointer()

actual typealias Var = CVariable

actual inline fun <reified T : Var> sizeOf(): Long = sizeOf<T>()

actual inline fun <reified T : Var> alignOf(): Int = alignOf<T>()

// START POINTER VARS

actual typealias PtrVarOf<T> = CPointerVarOf<T>

actual inline var <P : Ptr<*>> PtrVarOf<P>.value: P?
	get() = this.value
	set(value) { this.value = value }

actual inline val <reified T : Ptd, reified P : Ptr<T>> PtrVarOf<P>.pointed: T? get() = this.pointed

// END POINTER VARS

// START PRIMITIVE BYTE VARS

// Byte

actual inline fun CString.toKString(): String = this.toKString()

actual typealias ByteVarOf<T> = kotlinx.cinterop.ByteVarOf<T>

actual inline var <T : Byte> ByteVarOf<T>.value: T
	get() = this.value
	set(value) { this.value = value }

actual inline fun ByteArray.refTo(index: Int): ValuesRef<ByteVar> = this.refTo(index)

// UByte

actual typealias UByteVarOf<T> = kotlinx.cinterop.UByteVarOf<T>

actual inline var <T : UByte> UByteVarOf<T>.value: T
	get() = this.value
	set(value) { this.value = value }

actual inline fun UByteArray.refTo(index: Int): ValuesRef<UByteVar> = this.refTo(index)

// END PRIMITIVE BYTE VARS

// START PRIMITIVE INT VARS

// Int

actual typealias IntVarOf<T> = kotlinx.cinterop.IntVarOf<T>

actual inline var <T : Int> IntVarOf<T>.value: T
	get() = this.value
	set(value) { this.value = value }

actual inline fun IntArray.refTo(index: Int): ValuesRef<IntVar> = this.refTo(index)

// UInt

actual typealias UIntVarOf<T> = kotlinx.cinterop.UIntVarOf<T>

actual inline var <T : UInt> UIntVarOf<T>.value: T
	get() = this.value
	set(value) { this.value = value }

actual inline fun UIntArray.refTo(index: Int): ValuesRef<UIntVar> = this.refTo(index)

// END PRIMITIVE INT VARS

// START PRIMITIVE FLOAT VARS

// Float

actual typealias FloatVarOf<T> = kotlinx.cinterop.FloatVarOf<T>

actual inline var <T : Float> FloatVarOf<T>.value: T
	get() = this.value
	set(value) { this.value = value }

actual inline fun FloatArray.refTo(index: Int): ValuesRef<FloatVar> = this.refTo(index)

// There is no UFloat (in ba sing se)

// END PRIMITIVE FLOAT VARS

actual typealias ValuesRef<T> = CValuesRef<T>

actual typealias Ptr<T> = CPointer<T>

actual typealias Mem = NativePlacement

actual typealias FMem = NativeFreeablePlacement

actual inline fun Mem.alloc(size: Long, align: Int): NPtd = this.alloc(size, align)

actual inline fun <reified T : Var> Mem.alloc(): T = this.alloc()

actual inline fun <reified T : Var> Mem.allocArray(length: Long): ArrayPtr<T> = this.allocArray(length)

actual inline fun Mem.allocArrayOf(vararg elements: Float): ArrayPtr<FloatVar> = this.allocArrayOf(*elements)

actual inline fun <T : Ptd> Mem.allocPtrTo(): PtrVarOf<Ptr<T>> = this.allocPointerTo()

actual inline fun FMem.free(ptr: Ptr<*>): Unit = this.free(ptr)

actual inline fun FMem.free(ptr: NPtd): Unit = this.free(ptr)

actual typealias HMem = nativeHeap

actual inline fun exitProcess(status: Int): Nothing = kotlin.system.exitProcess(status)

actual const val EXIT_SUCCESS: Int = platform.posix.EXIT_SUCCESS

actual const val EXIT_FAILURE: Int = platform.posix.EXIT_FAILURE