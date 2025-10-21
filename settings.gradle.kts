rootProject.name = "KMP_GE"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

// TODO: Move glfw interop to a separate module?
include(":core")