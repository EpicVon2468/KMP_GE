package io.github.epicvon2468.core.interop

@GLWrapper
actual fun glGetString(name: UInt): String? = TODO()

@GLWrapper
actual fun glGetString(name: Int): String? = glGetString(name.toUInt())

@GLWrapper
actual val GL_SHADING_LANGUAGE_VERSION: Int get() = TODO()