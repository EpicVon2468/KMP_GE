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