package io.github.epicvon2468.core.interop.glfw.window

import io.github.epicvon2468.core.interop.glfw.GLFW
import io.github.epicvon2468.core.interop.glfw.monitor.GLFWMonitor

@GLFW
actual fun glfwDefaultWindowHints(): Unit = TODO()

@GLFW
actual fun glfwWindowHint(hint: Int, value: Int): Unit = TODO()

@GLFW
actual fun glfwWindowHintString(hint: Int, value: String?): Unit = TODO()

@GLFW
actual fun glfwCreateWindow(
	width: Int,
	height: Int,
	title: String?,
	monitor: GLFWMonitor?,
	share: GLFWWindow?
): GLFWWindow? = TODO()

@GLFW
actual fun glfwDestroyWindow(window: GLFWWindow?): Unit = TODO()

@GLFW
actual fun glfwWindowShouldClose(window: GLFWWindow?): Boolean = TODO()

@GLFW
actual fun glfwGetWindowTitle(window: GLFWWindow?): String? = TODO()

@GLFW
actual fun glfwSetWindowTitle(window: GLFWWindow?, title: String?): Unit = TODO()

@GLFW
actual fun glfwSetWindowIcon(window: GLFWWindow?, count: Int, images: GLFWImage?): Unit = TODO()

@GLFW
actual fun glfwSetWindowSizeLimits(
	window: GLFWWindow?,
	minWidth: Int,
	minHeight: Int,
	maxWidth: Int,
	maxHeight: Int
): Unit = TODO()

@GLFW
actual fun glfwSetWindowAspectRatio(window: GLFWWindow?, numer: Int, demon: Int): Unit = TODO()

@GLFW
actual fun glfwSetWindowSize(window: GLFWWindow?, width: Int, height: Int): Unit = TODO()

@GLFW
actual fun glfwGetWindowOpacity(window: GLFWWindow?): Float = TODO()

@GLFW
actual fun glfwSetWindowOpacity(window: GLFWWindow?, opacity: Float): Unit = TODO()

@GLFW
actual fun glfwIconifyWindow(window: GLFWWindow?): Unit = TODO()

@GLFW
actual fun glfwRestoreWindow(window: GLFWWindow?): Unit = TODO()

@GLFW
actual fun glfwMaximiseWindow(window: GLFWWindow?): Unit = TODO()

@GLFW
actual fun glfwShowWindow(window: GLFWWindow?): Unit = TODO()

@GLFW
actual fun glfwHideWindow(window: GLFWWindow?): Unit = TODO()

@GLFW
actual fun glfwFocusWindow(window: GLFWWindow?): Unit = TODO()

@GLFW
actual fun glfwRequestWindowAttention(window: GLFWWindow?): Unit = TODO()

//

@GLFW
actual fun glfwPollEvents(): Unit = TODO()

@GLFW
actual fun glfwSwapBuffers(window: GLFWWindow?): Unit = TODO()

//