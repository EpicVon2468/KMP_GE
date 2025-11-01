package io.github.epicvon2468.kmp_ge.core.interop

actual open class NPtd

actual abstract class Ptd : NPtd()

actual abstract class Var : Ptd()

actual class Ptr<T : Ptd>()

actual interface Mem

actual interface FMem : Mem

actual fun Mem.alloc(size: Long, align: Int): NPtd = TODO()

actual inline fun <reified T : Var> Mem.alloc(): T = TODO()

actual fun FMem.free(ptr: Ptr<*>): Unit = TODO()

actual fun FMem.free(ptr: NPtd): Unit = TODO()

actual object HMem : Mem

@Suppress("NOTHING_TO_INLINE")
actual inline fun exitProcess(status: Int): Nothing = kotlin.system.exitProcess(status)

actual const val EXIT_SUCCESS: Int = 0

actual const val EXIT_FAILURE: Int = -1