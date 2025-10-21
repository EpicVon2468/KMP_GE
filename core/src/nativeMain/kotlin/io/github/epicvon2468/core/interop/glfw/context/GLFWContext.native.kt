@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE")
package io.github.epicvon2468.core.interop.glfw.context

import io.github.epicvon2468.core.interop.glfw.GLFW
import io.github.epicvon2468.core.interop.glfw.GLFWWindow
import io.github.epicvon2468.core.interop.glfw.GLFWWindowC
import io.github.epicvon2468.core.interop.glfw.glfwBoolean
import io.github.epicvon2468.core.interop.glfw.window

import kotlinx.cinterop.ExperimentalForeignApi

@GLFW
actual inline fun glfwMakeContextCurrent(window: GLFWWindow?) = glfw.glfwMakeContextCurrent(window.window)

@GLFW
actual inline fun glfwGetCurrentContext(): GLFWWindow? = glfw.glfwGetCurrentContext()?.let(::GLFWWindowC)

@GLFW
actual inline fun glfwSwapInterval(interval: Int) = glfw.glfwSwapInterval(interval)

@GLFW
actual inline fun glfwExtensionSupported(extension: String?): Boolean =
	glfw.glfwExtensionSupported(extension).glfwBoolean()