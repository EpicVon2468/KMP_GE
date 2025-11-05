import com.codingfeline.buildkonfig.compiler.FieldSpec
import org.gradle.internal.os.OperatingSystem
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTargetWithHostTests

plugins {
	alias(libs.plugins.kotlin.multiplatform)
	alias(libs.plugins.buildKonfig)
}

group = "io.github.epicvon2468.cinterop"
version = "0.0.0"

fun configureNativeTargets(it: KotlinNativeTargetWithHostTests) = with(it) {
	binaries {
		sharedLib()
		staticLib()
	}
//	compilations.getByName("main") {
//		cinterops {
//			val glfw by creating
//			val gl by creating
//			val linearmaths by creating
//			val kmp_ge by creating
//		}
//	}
}

kotlin {

	jvm()

	val os = OperatingSystem.current()
	if (os.isLinux) linuxX64(::configureNativeTargets)
	if (os.isWindows) mingwX64(::configureNativeTargets)
	if (os.isMacOsX) macosX64(::configureNativeTargets)

	sourceSets {
		commonMain.dependencies {}

		jvmMain.dependencies {}

		commonTest.dependencies {
			implementation(kotlin("test"))
		}
	}

	compilerOptions.freeCompilerArgs.add("-Xexpect-actual-classes")
}

buildkonfig {
	// BuildKonfig configuration here.
	// https://github.com/yshrsmz/BuildKonfig#gradle-configuration
	packageName = "io.github.epicvon2468.kmp_ge.cinterop"
	exposeObjectWithName = "Info"
	defaultConfigs {
		buildConfigField(FieldSpec.Type.STRING, "VERSION", version.toString())
	}
}