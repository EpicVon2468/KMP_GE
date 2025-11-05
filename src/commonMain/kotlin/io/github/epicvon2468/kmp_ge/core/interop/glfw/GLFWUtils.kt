package io.github.epicvon2468.kmp_ge.core.interop.glfw

import io.github.epicvon2468.kmp_ge.core.interop.glfw.init.GLFW_FALSE
import io.github.epicvon2468.kmp_ge.core.interop.glfw.init.GLFW_TRUE

// TODO: For JVM: https://www.baeldung.com/jni or https://www.lwjgl.org/

@GLFW
@Suppress("NOTHING_TO_INLINE")
inline fun Int.glfwBoolean(): Boolean = when (this) {
	GLFW_TRUE -> true
	GLFW_FALSE -> false
	else -> error("Couldn't parse glfw boolean '$this', expected either '$GLFW_TRUE' (true) or '$GLFW_FALSE' (false)!")
}

@GLFW
@Suppress("NOTHING_TO_INLINE")
inline fun Boolean.glfwBoolean(): Int = when (this) {
	true -> GLFW_TRUE
	false -> GLFW_FALSE
}