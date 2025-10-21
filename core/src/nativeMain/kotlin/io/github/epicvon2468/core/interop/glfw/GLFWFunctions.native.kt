@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE")
package io.github.epicvon2468.core.interop.glfw

import kotlinx.cinterop.ExperimentalForeignApi

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
actual inline fun glfwPollEvents() = glfw.glfwPollEvents()

@GLFW
actual inline fun glfwSwapBuffers(window: GLFWWindow?) = glfw.glfwSwapBuffers(window.window)

@GLFW
actual inline fun glfwWindowShouldClose(window: GLFWWindow?): Boolean =
	glfw.glfwWindowShouldClose(window.window).glfwBoolean()