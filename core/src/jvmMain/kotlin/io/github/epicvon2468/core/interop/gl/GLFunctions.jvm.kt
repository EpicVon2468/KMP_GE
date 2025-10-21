package io.github.epicvon2468.core.interop.gl

@GL
actual fun glGetString(name: UInt): String? = TODO()

@GL
actual fun glGetString(name: Int): String? = glGetString(name.toUInt())