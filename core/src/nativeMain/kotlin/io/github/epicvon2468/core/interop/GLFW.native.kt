@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("NOTHING_TO_INLINE")
package io.github.epicvon2468.core.interop

import glfw.GLFW_TRUE

import kotlinx.cinterop.ExperimentalForeignApi

actual inline fun glfwInit(): Boolean = glfw.glfwInit() == GLFW_TRUE

actual inline fun glfwTerminate() = glfw.glfwTerminate()

actual inline fun glfwSwapInterval(interval: Int) = glfw.glfwSwapInterval(interval)