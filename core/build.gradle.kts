import org.gradle.internal.os.OperatingSystem
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTargetWithHostTests

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialisation)
    alias(libs.plugins.buildKonfig)
}

// Even though having an extension function would perfectly fulfil the requirements, it doesn't let you use that.
fun configureNativeTargets(it: KotlinNativeTargetWithHostTests) = with(it) {
	binaries {
		executable {
			entryPoint = "io.github.epicvon2468.core.main"
		}
	}
	compilations.getByName("main") {
		cinterops {
			val glfw by creating
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
}

buildkonfig {
    // BuildKonfig configuration here.
    // https://github.com/yshrsmz/BuildKonfig#gradle-configuration
    packageName = "io.github.epicvon2468.core"
    defaultConfigs {
    }
}