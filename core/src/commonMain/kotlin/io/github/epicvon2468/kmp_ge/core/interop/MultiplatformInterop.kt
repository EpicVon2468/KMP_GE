package io.github.epicvon2468.kmp_ge.core.interop

expect open class NPtd

expect abstract class Ptd : NPtd

expect abstract class Var : Ptd

expect class Ptr<T : Ptd>

expect interface Mem

expect interface FMem : Mem

expect fun Mem.alloc(size: Long, align: Int): NPtd

fun Mem.alloc(size: Int, align: Int): NPtd = this.alloc(size.toLong(), align)

expect inline fun <reified T : Var> Mem.alloc(): T

expect fun FMem.free(ptr: Ptr<*>)

expect fun FMem.free(ptr: NPtd)

/**
 * Heap memory.
 */
expect object HMem : Mem

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