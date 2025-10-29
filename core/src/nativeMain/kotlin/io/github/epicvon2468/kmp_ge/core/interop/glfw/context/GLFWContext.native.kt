@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE")
package io.github.epicvon2468.kmp_ge.core.interop.glfw.context

import io.github.epicvon2468.kmp_ge.core.interop.glfw.GLFW
import io.github.epicvon2468.kmp_ge.core.interop.glfw.window.GLFWWindow
import io.github.epicvon2468.kmp_ge.core.interop.glfw.window.GLFWWindowC
import io.github.epicvon2468.kmp_ge.core.interop.glfw.window.window
import io.github.epicvon2468.kmp_ge.core.interop.glfw.glfwBoolean

import kotlinx.cinterop.ExperimentalForeignApi

@GLFW
data class GLFWGLProcC(val proc: glfw.GLFWglproc) : GLFWGLProc

@GLFW
inline val GLFWGLProc?.proc: glfw.GLFWglproc? get() = (this as? GLFWGLProcC)?.proc

@GLFW
actual inline fun glfwMakeContextCurrent(window: GLFWWindow?) = glfw.glfwMakeContextCurrent(window.window)

@GLFW
actual inline fun glfwGetCurrentContext(): GLFWWindow? = glfw.glfwGetCurrentContext()?.let(::GLFWWindowC)

@GLFW
actual inline fun glfwSwapInterval(interval: Int) = glfw.glfwSwapInterval(interval)

@GLFW
actual inline fun glfwExtensionSupported(extension: String?): Boolean =
	glfw.glfwExtensionSupported(extension).glfwBoolean()

@GLFW
actual inline fun glfwGetProcAddress(name: String?): GLFWGLProc? = glfw.glfwGetProcAddress(name)?.let(::GLFWGLProcC)