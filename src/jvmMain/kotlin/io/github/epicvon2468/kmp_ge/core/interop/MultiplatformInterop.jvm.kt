@file:Suppress("NOTHING_TO_INLINE")
package io.github.epicvon2468.kmp_ge.core.interop

// TODO: https://stackoverflow.com/questions/1632367/passing-pointers-between-c-and-java-through-jni
// 	There's a CInterop function for getting pointers by long and turning them to long as well.

// Additionally, check out: https://docs.oracle.com/en/java/javase/21/core/foreign-function-and-memory-api.html (jvm 21+)

actual open class NPtd

actual abstract class Ptd : NPtd()

actual inline val <T : Ptd> T.ptr: Ptr<T> get() = TODO()

actual inline val <reified T : Ptd> Ptr<T>.pointed: T get() = TODO()

actual fun <T : Ptd> Ptr<*>.reinterpret(): Ptr<T> = TODO()

actual fun <T : Ptd> Ptr<T>?.toLong(): Long = TODO()

actual fun <T : Ptd> Long.toPtr(): Ptr<T>? = TODO()

actual abstract class Var : Ptd()

actual inline fun <reified T : Var> sizeOf(): Long = TODO()

actual inline fun <reified T : Var> alignOf(): Int = TODO()

// START POINTER VARS

actual class PtrVarOf<T : Ptr<*>> : Var()

actual var <P : Ptr<*>> PtrVarOf<P>.value: P?
	get() = TODO()
	set(value) = TODO()

actual inline val <reified T : Ptd, reified P : Ptr<T>> PtrVarOf<P>.pointed: T? get() = TODO()

// END POINTER VARS

actual abstract class ValuesRef<T : Ptd>

actual class Ptr<T : Ptd>() : ValuesRef<T>()

actual interface Mem

actual interface FMem : Mem

actual inline fun Mem.alloc(size: Long, align: Int): NPtd = TODO()

actual inline fun <reified T : Var> Mem.alloc(): T = TODO()

actual inline fun <T : Ptd> Mem.allocPtrTo(): PtrVarOf<Ptr<T>> = TODO()

actual inline fun FMem.free(ptr: Ptr<*>): Unit = TODO()

actual inline fun FMem.free(ptr: NPtd): Unit = TODO()

actual object HMem : FMem

@Suppress("NOTHING_TO_INLINE")
actual inline fun exitProcess(status: Int): Nothing = kotlin.system.exitProcess(status)

actual const val EXIT_SUCCESS: Int = 0

actual const val EXIT_FAILURE: Int = -1