package io.github.epicvon2468.kmp_ge.core.interop

actual abstract class Ptd

actual class Ptr<T : Ptd>()

@Suppress("NOTHING_TO_INLINE")
actual inline fun exitProcess(status: Int): Nothing = kotlin.system.exitProcess(status)

actual const val EXIT_SUCCESS: Int = 0

actual const val EXIT_FAILURE: Int = -1