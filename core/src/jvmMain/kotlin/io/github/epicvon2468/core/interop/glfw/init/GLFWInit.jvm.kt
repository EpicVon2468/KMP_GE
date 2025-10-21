package io.github.epicvon2468.core.interop.glfw.init

import io.github.epicvon2468.core.interop.glfw.GLFW

@GLFW
actual val GLFW_TRUE: Int get() = TODO()

@GLFW
actual val GLFW_FALSE: Int get() = TODO()

@GLFW
actual fun glfwInit(): Boolean = TODO()

@GLFW
actual fun glfwTerminate(): Unit = TODO()

@GLFW
actual fun glfwInitHint(hint: Int, value: Int): Unit = TODO()

@GLFW
actual fun glfwSetErrorCallback(callback: GLFWErrorFun?): Unit = TODO()

@GLFW
actual fun glfwGetVersionString(): String = TODO()

@GLFW
actual fun glfwGetPlatform(): Int = TODO()

@GLFW
actual fun glfwPlatformSupported(platform: Int): Boolean = TODO()