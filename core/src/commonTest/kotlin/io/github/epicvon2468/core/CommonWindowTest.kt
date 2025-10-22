package io.github.epicvon2468.core

import io.github.epicvon2468.core.interop.glfw.context.glfwMakeContextCurrent
import io.github.epicvon2468.core.interop.glfw.context.glfwSwapInterval
import io.github.epicvon2468.core.interop.glfw.init.glfwInit
import io.github.epicvon2468.core.interop.glfw.init.glfwSetErrorCallback
import io.github.epicvon2468.core.interop.glfw.init.glfwTerminate
import io.github.epicvon2468.core.interop.glfw.window.GLFWWindow
import io.github.epicvon2468.core.interop.glfw.window.glfwCreateWindow
import io.github.epicvon2468.core.interop.glfw.window.glfwDestroyWindow
import io.github.epicvon2468.core.interop.glfw.window.glfwPollEvents
import io.github.epicvon2468.core.interop.glfw.window.glfwSetWindowShouldClose
import io.github.epicvon2468.core.interop.glfw.window.glfwSwapBuffers
import io.github.epicvon2468.core.interop.glfw.window.glfwWindowShouldClose

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.fail
import kotlin.time.Clock
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime

class CommonWindowTest {

	@Test
	@OptIn(ExperimentalTime::class)
	fun commonWindowTest() {
		assertTrue(glfwInit(), "GLFW failed to initialise!")
		glfwSetErrorCallback { errorCode: Int, description: String? ->
			fail("GLFW had an error! Error was: (errorCode: '$errorCode', description: '$description').")
		}
		val window: GLFWWindow? = glfwCreateWindow(1, 1, "Common Test Window")
		if (window == null) {
			glfwTerminate()
			fail("GLFWWindow failed to create!")
		}

		glfwMakeContextCurrent(window)
		// V-Sync.
		glfwSwapInterval(1)

		val startTime = Clock.System.now()
		while (!glfwWindowShouldClose(window)) {
			if (Clock.System.now().minus(startTime) >= 10.seconds) glfwSetWindowShouldClose(window, true)
			glfwSwapBuffers(window)
			glfwPollEvents()
		}

		glfwDestroyWindow(window)
		glfwTerminate()
	}
}