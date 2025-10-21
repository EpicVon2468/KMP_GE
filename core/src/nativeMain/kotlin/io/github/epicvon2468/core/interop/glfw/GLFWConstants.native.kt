@file:OptIn(ExperimentalForeignApi::class)
package io.github.epicvon2468.core.interop.glfw

import kotlinx.cinterop.ExperimentalForeignApi

@GLFW
actual const val GLFW_TRUE: Int = glfw.GLFW_TRUE

@GLFW
actual const val GLFW_FALSE: Int = glfw.GLFW_FALSE