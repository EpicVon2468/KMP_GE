package io.github.epicvon2468.core.interop

actual fun glGetString(name: UInt): String? = TODO()

actual fun glGetString(name: Int): String? = glGetString(name.toUInt())