@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE")
package io.github.epicvon2468.core.interop.glfw.window

import io.github.epicvon2468.core.interop.glfw.GLFW
import io.github.epicvon2468.core.interop.glfw.glfwBoolean
import io.github.epicvon2468.core.interop.glfw.monitor.monitor
import io.github.epicvon2468.core.interop.glfw.monitor.GLFWMonitor

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValuesRef
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.toKString

/**
 * CInterop implementation of the [io.github.epicvon2468.core.interop.glfw.window.GLFWWindow] interface.
 */
@GLFW
data class GLFWWindowC(val window: CPointer<cnames.structs.GLFWwindow>?) : GLFWWindow

@GLFW
inline val GLFWWindow?.window: CPointer<cnames.structs.GLFWwindow>? get() = (this as? GLFWWindowC)?.window

@GLFW
data class GLFWImageC(val image: CValuesRef<glfw.GLFWimage>?) : GLFWImage

@GLFW
inline val GLFWImage?.image: CValuesRef<glfw.GLFWimage>? get() = (this as? GLFWImageC)?.image

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

@GLFW
actual inline fun glfwGetWindowTitle(window: GLFWWindow?): String? = glfw.glfwGetWindowTitle(window.window)?.toKString()

@GLFW
actual inline fun glfwSetWindowTitle(window: GLFWWindow?, title: String?) =
	glfw.glfwSetWindowTitle(window.window, title)

@GLFW
actual inline fun glfwSetWindowIcon(window: GLFWWindow?, count: Int, images: GLFWImage?) =
	glfw.glfwSetWindowIcon(window.window, count, images.image)

@GLFW
actual inline fun glfwSetWindowSizeLimits(
	window: GLFWWindow?,
	minWidth: Int,
	minHeight: Int,
	maxWidth: Int,
	maxHeight: Int
) = glfw.glfwSetWindowSizeLimits(window.window, minWidth, minHeight, maxWidth, maxHeight)

@GLFW
actual inline fun glfwSetWindowAspectRatio(window: GLFWWindow?, numer: Int, demon: Int) =
	glfw.glfwSetWindowAspectRatio(window.window, numer, demon)

@GLFW
actual inline fun glfwSetWindowSize(window: GLFWWindow?, width: Int, height: Int) =
	glfw.glfwSetWindowSize(window.window, width, height)

@GLFW
actual inline fun glfwGetWindowOpacity(window: GLFWWindow?): Float = glfw.glfwGetWindowOpacity(window.window)

@GLFW
actual inline fun glfwSetWindowOpacity(window: GLFWWindow?, opacity: Float) =
	glfw.glfwSetWindowOpacity(window.window, opacity)

@GLFW
actual fun glfwIconifyWindow(window: GLFWWindow?) = glfw.glfwIconifyWindow(window.window)

@GLFW
actual fun glfwRestoreWindow(window: GLFWWindow?) = glfw.glfwRestoreWindow(window.window)

@GLFW
actual fun glfwMaximiseWindow(window: GLFWWindow?) = glfw.glfwMaximizeWindow(window.window)

@GLFW
actual fun glfwShowWindow(window: GLFWWindow?) = glfw.glfwShowWindow(window.window)

@GLFW
actual fun glfwHideWindow(window: GLFWWindow?) = glfw.glfwHideWindow(window.window)

@GLFW
actual fun glfwFocusWindow(window: GLFWWindow?) = glfw.glfwFocusWindow(window.window)

@GLFW
actual fun glfwRequestWindowAttention(window: GLFWWindow?) = glfw.glfwRequestWindowAttention(window.window)

//

@GLFW
actual inline fun glfwPollEvents() = glfw.glfwPollEvents()

@GLFW
actual inline fun glfwSwapBuffers(window: GLFWWindow?) = glfw.glfwSwapBuffers(window.window)

//