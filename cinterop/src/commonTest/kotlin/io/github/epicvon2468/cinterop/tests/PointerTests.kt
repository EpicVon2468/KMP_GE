package io.github.epicvon2468.cinterop.tests

import io.github.epicvon2468.cinterop.NULL

import kotlin.test.Test
import kotlin.test.assertTrue

class PointerTests {

	// Print statements are important for JVM, where it could potentially crash due to the JNI lib not being present.
	@Test
	fun nullPointerTest() {
		println("Pre null.")
		println("Null is '$NULL'.")
		assertTrue(true) // Won't ever reach this point if the lib wasn't loaded.
		println("Post null.")
	}
}