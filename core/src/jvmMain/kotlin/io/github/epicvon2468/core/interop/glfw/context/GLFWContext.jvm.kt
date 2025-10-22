package io.github.epicvon2468.core.interop.glfw.context

import io.github.epicvon2468.core.interop.glfw.GLFW
import io.github.epicvon2468.core.interop.glfw.window.GLFWWindow

@GLFW
actual fun glfwMakeContextCurrent(window: GLFWWindow?): Unit = TODO()

@GLFW
actual fun glfwGetCurrentContext(): GLFWWindow? = TODO()

@GLFW
actual fun glfwSwapInterval(interval: Int): Unit = TODO()

@GLFW
actual fun glfwExtensionSupported(extension: String?): Boolean = TODO()

@GLFW
actual fun glfwGetProcAddress(name: String?): GLFWGLProc? = TODO()