package io.github.epicvon2468.core.interop

@DslMarker
annotation class GLWrapper

@GLWrapper
expect fun glGetString(name: UInt): String?

@GLWrapper
expect fun glGetString(name: Int): String?