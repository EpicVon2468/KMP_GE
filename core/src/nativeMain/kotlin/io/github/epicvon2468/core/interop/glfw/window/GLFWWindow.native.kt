@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE")
package io.github.epicvon2468.core.interop.glfw.window

import io.github.epicvon2468.core.interop.glfw.GLFW
import io.github.epicvon2468.core.interop.glfw.glfwBoolean
import io.github.epicvon2468.core.interop.glfw.monitor.monitor
import io.github.epicvon2468.core.interop.glfw.monitor.GLFWMonitor

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi

/**
 * CInterop implementation of the [io.github.epicvon2468.core.interop.glfw.window.GLFWWindow] interface.
 */
@GLFW
data class GLFWWindowC(val window: CPointer<cnames.structs.GLFWwindow>?) : GLFWWindow

@GLFW
inline val GLFWWindow?.window: CPointer<cnames.structs.GLFWwindow>? get() = (this as? GLFWWindowC)?.window

@GLFW
actual inline fun glfwDefaultWindowHints() = glfw.glfwDefaultWindowHints()

@GLFW
actual inline fun glfwWindowHint(hint: Int, value: Int) = glfw.glfwWindowHint(hint, value)

@GLFW
actual inline fun glfwWindowHintString(hint: Int, value: String?) = glfw.glfwWindowHintString(hint, value)

@GLFW
actual inline fun glfwCreateWindow(
	width: Int,
	height: Int,
	title: String?,
	monitor: GLFWMonitor?/* = null*/,
	share: GLFWWindow?/* = null*/
): GLFWWindow? = glfw.glfwCreateWindow(width, height, title, monitor.monitor, share.window).let(::GLFWWindowC)

@GLFW
actual inline fun glfwDestroyWindow(window: GLFWWindow?) = glfw.glfwDestroyWindow(window.window)

@GLFW
actual inline fun glfwWindowShouldClose(window: GLFWWindow?): Boolean =
	glfw.glfwWindowShouldClose(window.window).glfwBoolean()

//

@GLFW
actual inline fun glfwPollEvents() = glfw.glfwPollEvents()

@GLFW
actual inline fun glfwSwapBuffers(window: GLFWWindow?) = glfw.glfwSwapBuffers(window.window)

//