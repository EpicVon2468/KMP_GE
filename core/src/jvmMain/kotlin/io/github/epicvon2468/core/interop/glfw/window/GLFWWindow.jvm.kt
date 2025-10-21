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

//

@GLFW
actual fun glfwPollEvents(): Unit = TODO()

@GLFW
actual fun glfwSwapBuffers(window: GLFWWindow?): Unit = TODO()

//