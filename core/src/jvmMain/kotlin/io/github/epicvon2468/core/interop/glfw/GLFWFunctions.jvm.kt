package io.github.epicvon2468.core.interop.glfw

// TODO: https://www.baeldung.com/jni or https://www.lwjgl.org/

@GLFW
actual fun glfwInit(): Boolean = TODO()

@GLFW
actual fun glfwTerminate(): Unit = TODO()

@GLFW
actual fun glfwSwapInterval(interval: Int): Unit = TODO()

@GLFW
actual fun glfwSetErrorCallback(callback: GLFWErrorFun?): Unit = TODO()

@GLFW
actual fun glfwMakeContextCurrent(window: GLFWWindow?): Unit = TODO()

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