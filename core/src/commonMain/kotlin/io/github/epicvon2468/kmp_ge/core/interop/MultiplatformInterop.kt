@file:OptIn(ExperimentalUnsignedTypes::class)
@file:Suppress("FINAL_UPPER_BOUND", "NOTHING_TO_INLINE")
package io.github.epicvon2468.kmp_ge.core.interop

expect open class NPtd

expect abstract class Ptd : NPtd

/**
 * Native pointer
 */
expect class NPtr

expect val <T : Ptd> T.ptr: Ptr<T>

expect inline val <reified T : Ptd> Ptr<T>.pointed: T

expect inline operator fun <reified T : Var> Ptr<T>.get(index: Long): T

inline operator fun <reified T : Var> Ptr<T>.get(index: Int): T = this[index.toLong()]

expect inline operator fun <reified T : PtrVarOf<*>> Ptr<T>?.plus(index: Long): Ptr<T>?

inline operator fun <reified T : PtrVarOf<*>> Ptr<T>?.plus(index: Int): Ptr<T>? = this + index.toLong()

inline operator fun <T : Ptr<*>> Ptr<PtrVarOf<T>>.get(index: Long): T? = (this + index)!!.pointed.value

inline operator fun <T : Ptr<*>> Ptr<PtrVarOf<T>>.get(index: Int): T? = this[index.toLong()]

inline operator fun <T : Ptr<*>> Ptr<PtrVarOf<T>>.set(index: Long, value: T?) { (this + index)!!.pointed.value = value }

inline operator fun <T : Ptr<*>> Ptr<PtrVarOf<T>>.set(index: Int, value: T?) { this[index.toLong()] = value }

expect val NULL: NPtr

expect val Ptr<*>?.rawValue: NPtr

// Make this just be an inline cast on JVM if possible.
expect fun <T : Ptd> Ptr<*>.reinterpret(): Ptr<T>

expect fun <T : Ptd> Ptr<T>?.toLong(): Long

expect fun <T : Ptd> Long.toPtr(): Ptr<T>?

expect abstract class Var : Ptd

expect inline fun <reified T : Var> sizeOf(): Long

expect inline fun <reified T : Var> alignOf(): Int

// START POINTER VARS

typealias OpaquePtr = Ptr<out Ptd>

typealias PtrVar<T> = PtrVarOf<Ptr<T>>

expect class PtrVarOf<T : Ptr<*>> : Var

expect inline var <P : Ptr<*>> PtrVarOf<P>.value: P?

expect inline val <reified T : Ptd, reified P : Ptr<T>> PtrVarOf<P>.pointed: T?

// END POINTER VARS

// START PRIMITIVE BYTE VARS

// Byte

typealias CString = ArrayPtr<ByteVar>

expect fun CString.toKString(): String

typealias ByteVar = ByteVarOf<Byte>

expect class ByteVarOf<T : Byte> : Var

expect var <T : Byte> ByteVarOf<T>.value: T

expect fun ByteArray.refTo(index: Int): ValuesRef<ByteVar>

// UByte

typealias UByteVar = UByteVarOf<UByte>

expect class UByteVarOf<T : UByte> : Var

expect var <T : UByte> UByteVarOf<T>.value: T

expect fun UByteArray.refTo(index: Int): ValuesRef<UByteVar>

// END PRIMITIVE BYTE VARS

// START PRIMITIVE INT VARS

// Int

typealias IntVar = IntVarOf<Int>

expect class IntVarOf<T : Int> : Var

expect var <T : Int> IntVarOf<T>.value: T

expect fun IntArray.refTo(index: Int): ValuesRef<IntVar>

// UInt

typealias UIntVar = UIntVarOf<UInt>

expect class UIntVarOf<T : UInt> : Var

expect var <T : UInt> UIntVarOf<T>.value: T

expect fun UIntArray.refTo(index: Int): ValuesRef<UIntVar>

// END PRIMITIVE INT VARS

// START PRIMITIVE FLOAT VARS

// Float

typealias FloatVar = FloatVarOf<Float>

expect class FloatVarOf<T : Float> : Var

expect var <T : Float> FloatVarOf<T>.value: T

expect fun FloatArray.refTo(index: Int): ValuesRef<FloatVar>

// There is no UFloat (in ba sing se)

// END PRIMITIVE FLOAT VARS

expect abstract class ValuesRef<T : Ptd>

typealias ArrayPtr<T> = Ptr<T>

expect class Ptr<T : Ptd> : ValuesRef<T>

/**
 * Non-freeable (immutable) memory.
 */
expect interface Mem

/**
 * Freeable (mutable) memory.
 */
expect interface FMem : Mem

expect fun Mem.alloc(size: Long, align: Int): NPtd

inline fun Mem.alloc(size: Int, align: Int): NPtd = this.alloc(size.toLong(), align)

expect inline fun <reified T : Var> Mem.alloc(): T

expect inline fun <reified T : Var> Mem.allocArray(length: Long): ArrayPtr<T>

inline fun <reified T : Var> Mem.allocArray(length: Int): ArrayPtr<T> = this.allocArray(length.toLong())

expect fun Mem.allocArrayOf(vararg elements: Float): ArrayPtr<FloatVar>

expect fun <T : Ptd> Mem.allocPtrTo(): PtrVarOf<Ptr<T>>

expect fun FMem.free(ptr: Ptr<*>)

expect fun FMem.free(ptr: NPtd)

/**
 * Heap memory.
 */
expect object HMem : FMem

/**
 * Terminates the currently running process.
 *
 * @param status serves as a status code; by convention,
 * a nonzero status code indicates abnormal termination.
 *
 * @return This method never returns normally.
 */
expect fun exitProcess(status: Int = EXIT_SUCCESS): Nothing

/**
 * Constant value for a successful process exit.
 *
 * This is almost always 0, however, in C, `EXIT_SUCCESS` and `EXIT_FAILURE`
 * may be different based on implementation, thus requiring this to be `expect` instead of a multiplatform constant.
 */
expect val EXIT_SUCCESS: Int

/**
 * Constant value for an unsuccessful process exit.
 *
 * The implementation of this constant is platform dependant.
 *
 * For JVM, it is set to `-1` as a generic error code.
 *
 * For native, it is dependent on the C implementation of `EXIT_FAILURE`.
 */
expect val EXIT_FAILURE: Int