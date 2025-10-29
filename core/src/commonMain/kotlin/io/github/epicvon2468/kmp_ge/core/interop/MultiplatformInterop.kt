package io.github.epicvon2468.kmp_ge.core.interop

expect abstract class Ptd

expect class Ptr<T : Ptd>

/**
 * Terminates the currently running process.
 *
 * @param status serves as a status code; by convention,
 * a nonzero status code indicates abnormal termination.
 *
 * @return This method never returns normally.
 */
expect fun exitProcess(status: Int = 0): Nothing