@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE")
package io.github.epicvon2468.core.interop

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.toKString

@GLWrapper
actual inline fun glGetString(name: UInt): String? = gl.glGetString(name)?.reinterpret<ByteVar>()?.toKString()

@GLWrapper
actual inline fun glGetString(name: Int): String? = glGetString(name.toUInt())

@GLWrapper
actual inline val GL_SHADING_LANGUAGE_VERSION: Int get() = gl.GL_SHADING_LANGUAGE_VERSION