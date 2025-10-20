package io.github.epicvon2468.core.interop

@GLFWWrapper
actual fun glfwInit(): Boolean = TODO()

@GLFWWrapper
actual fun glfwTerminate(): Unit = TODO()

@GLFWWrapper
actual fun glfwSwapInterval(interval: Int): Unit = TODO()

@GLFWWrapper
actual fun glfwSetErrorCallback(callback: GLFWErrorFun?): Unit = TODO()