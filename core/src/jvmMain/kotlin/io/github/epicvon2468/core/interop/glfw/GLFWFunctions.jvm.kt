package io.github.epicvon2468.core.interop.glfw

// TODO: https://www.baeldung.com/jni or https://www.lwjgl.org/

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
actual fun glfwPollEvents(): Unit = TODO()

@GLFW
actual fun glfwSwapBuffers(window: GLFWWindow?): Unit = TODO()

@GLFW
actual fun glfwWindowShouldClose(window: GLFWWindow?): Boolean = TODO()