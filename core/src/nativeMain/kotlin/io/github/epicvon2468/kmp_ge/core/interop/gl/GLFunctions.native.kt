@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE")
package io.github.epicvon2468.kmp_ge.core.interop.gl

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.invoke
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.toKString

@GL
actual inline fun glGetString(name: UInt): String? = gl.glGetString?.invoke(name)?.reinterpret<ByteVar>()?.toKString()

@GL
actual inline fun glGetString(name: Int): String? = glGetString(name.toUInt())