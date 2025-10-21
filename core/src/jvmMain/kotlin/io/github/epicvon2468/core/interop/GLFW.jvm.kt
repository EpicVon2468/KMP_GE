package io.github.epicvon2468.core.interop

// TODO: https://www.baeldung.com/jni or https://www.lwjgl.org/

@GLFWWrapper
actual fun glfwInit(): Boolean = TODO()

@GLFWWrapper
actual fun glfwTerminate(): Unit = TODO()

@GLFWWrapper
actual fun glfwSwapInterval(interval: Int): Unit = TODO()

@GLFWWrapper
actual fun glfwSetErrorCallback(callback: GLFWErrorFun?): Unit = TODO()

@GLFWWrapper
actual fun glfwMakeContextCurrent(window: GLFWWindow?): Unit = TODO()

@GLFWWrapper
actual fun glfwCreateWindow(
	width: Int,
	height: Int,
	title: String?,
	monitor: GLFWMonitor?,
	share: GLFWWindow?
): GLFWWindow? = TODO()

@GLFWWrapper
actual fun glfwDestroyWindow(window: GLFWWindow?): Unit = TODO()