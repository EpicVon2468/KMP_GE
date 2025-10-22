package io.github.epicvon2468.core.interop

actual abstract class Ptd

actual class Ptr<T : Ptd>()

@Suppress("NOTHING_TO_INLINE")
actual inline fun exitProcess(status: Int): Nothing = kotlin.system.exitProcess(status)