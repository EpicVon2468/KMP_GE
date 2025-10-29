import org.gradle.internal.os.OperatingSystem
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTargetWithHostTests

plugins {
	alias(libs.plugins.kotlin.multiplatform)
	alias(libs.plugins.kotlinx.serialisation)
	alias(libs.plugins.buildKonfig)
}

tasks.register("bakeInShaders") {
	doFirst {
		val projectDir = File(System.getProperty("user.dir"))
		val out = projectDir.resolve("core/src/nativeMain/kotlin/io/github/epicvon2468/kmp_ge/core/Shaders.kt")
		fun writeShaderConstants(shader: File, sb: StringBuilder) {
			for (line in shader.readText().split('\n')) {
				if (line.isEmpty() || line == "\n") continue
				val append = if (line.endsWith('\n')) line.substring(0..<line.lastIndex) else line
				sb.append("\t\"$append\\n\" +\n")
			}
		}
		projectDir.resolve("shader.vert").let {
			out.delete()
			out.createNewFile()
			val sb = StringBuilder("package io.github.epicvon2468.kmp_ge.core\n\nconst val VERTEX_SHADER: String =\n")
			writeShaderConstants(it, sb)
			out.writeText(sb.substring(0..<sb.lastIndex - 2) + "\n\n")
		}
		projectDir.resolve("shader.frag").let {
			val sb = StringBuilder("const val FRAGMENT_SHADER: String =\n")
			writeShaderConstants(it, sb)
			out.appendText(sb.substring(0..<sb.lastIndex - 2))
		}
		didWork = true
	}
	finalizedBy("runDebugExecutableLinuxX64")
}

tasks.register("generateCInteropDefs") {
	description =
		"Creates the .def files for `gl` and `linearmaths.def`, since they both need to use the files in `./core/c/include`, and that has to be hardcoded with the full directory."
	doFirst {
		println("Generating gl.def and linearmaths.def")

		val core = System.getProperty("user.dir") + "/core"
		val cInteropDir = File("$core/src/nativeInterop/cinterop")
		cInteropDir.resolve("gl.def").let {
			println("Generating gl.def")
			if (!it.exists()) it.createNewFile()
			val gladDir = "$core/c/include/glad"
			it.writeText(
				"""
					headers = glad/gl.h
					staticLibraries = libglad.a
					libraryPaths = $gladDir

					compilerOpts = -I$gladDir

					---

					void glShaderSourceK(GLenum shader, GLsizei count, const char* string, const GLint *length) {
						glShaderSource(shader, count, &string, length);
					}
				""".trimIndent()
			)
			println("Generated gl.def")
		}
		cInteropDir.resolve("linearmaths.def").let {
			println("Generating linearmaths.def")
			if (!it.exists()) it.createNewFile()
			it.writeText(
				"""
					headers = linearmaths.h

					compilerOpts = -I$core/c/include
				""".trimIndent()
			)
			println("Generated linearmaths.def")
		}
	}
	doLast {
		println("Generated gl.def and linearmaths.def")
		didWork = true
	}
}

// Even though having an extension function would perfectly fulfil the requirements, it doesn't let you use that.
fun configureNativeTargets(it: KotlinNativeTargetWithHostTests) = with(it) {
	binaries {
		executable {
			entryPoint = "io.github.epicvon2468.kmp_ge.core.main"
		}
	}
	compilations.getByName("main") {
		cinterops {
			val glfw by creating
			val gl by creating
			val linearmaths by creating
		}
	}
}

kotlin {

	jvm()

	val current = OperatingSystem.current()

	if (current.isLinux) linuxX64(::configureNativeTargets)

	if (current.isWindows) mingwX64(::configureNativeTargets)

	sourceSets {
		commonMain.dependencies {
			implementation(libs.kotlinx.coroutines.core)
			implementation(libs.kotlinx.serialisation.json)
			implementation(libs.kotlinx.datetime)
		}

		jvmMain.dependencies {
			implementation(libs.kotlinx.coroutines.swing)
		}

		commonTest.dependencies {
			implementation(kotlin("test"))
			implementation(libs.kotlinx.coroutines.test)
		}
	}

	compilerOptions.freeCompilerArgs.add("-Xexpect-actual-classes")
}

buildkonfig {
	// BuildKonfig configuration here.
	// https://github.com/yshrsmz/BuildKonfig#gradle-configuration
	packageName = "io.github.epicvon2468.kmp_ge.core"
	defaultConfigs {
	}
}