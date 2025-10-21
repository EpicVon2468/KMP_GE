package io.github.epicvon2468.core.interop.gl

@GL
expect fun glGetString(name: UInt): String?

@GL
expect fun glGetString(name: Int): String?