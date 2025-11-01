package io.github.epicvon2468.kmp_ge.core.interop

actual open class NPtd

actual abstract class Ptd : NPtd()

actual val <T : Ptd> T.ptr: Ptr<T> get() = TODO()

actual inline val <reified T : Ptd> Ptr<T>.pointed: T get() = TODO()

actual abstract class Var : Ptd()

// START POINTER VARS

actual class PtrVarOf<T : Ptr<*>> : Var()

actual class Ptr<T : Ptd>()

actual var <P : Ptr<*>> PtrVarOf<P>.value: P?
	get() = TODO()
	set(value) = TODO()

actual inline val <reified T : Ptd, reified P : Ptr<T>> PtrVarOf<P>.pointed: T? get() = TODO()

// END POINTER VARS

actual interface Mem

actual interface FMem : Mem

actual fun Mem.alloc(size: Long, align: Int): NPtd = TODO()

actual inline fun <reified T : Var> Mem.alloc(): T = TODO()

actual fun <T : Ptd> Mem.allocPtrTo(): PtrVarOf<Ptr<T>> = TODO()

actual fun FMem.free(ptr: Ptr<*>): Unit = TODO()

actual fun FMem.free(ptr: NPtd): Unit = TODO()

actual object HMem : FMem

@Suppress("NOTHING_TO_INLINE")
actual inline fun exitProcess(status: Int): Nothing = kotlin.system.exitProcess(status)

actual const val EXIT_SUCCESS: Int = 0

actual const val EXIT_FAILURE: Int = -1