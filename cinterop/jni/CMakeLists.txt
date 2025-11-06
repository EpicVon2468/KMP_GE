cmake_minimum_required(VERSION 4.0)
project(cinterop_jni CXX)

set(CMAKE_CXX_STANDARD 17)

include_directories(
        /usr/lib/jvm/java-21-openjdk-amd64/include/
        /usr/lib/jvm/java-21-openjdk-amd64/include/linux
)

add_library(
        cinterop_jni SHARED
        io_github_epicvon2468_cinterop_jni_JNIImpls.h
        JNIImpls.cpp
)

target_include_directories(cinterop_jni INTERFACE /usr/lib/jvm/java-21-openjdk-amd64/include/)
target_include_directories(cinterop_jni INTERFACE /usr/lib/jvm/java-21-openjdk-amd64/include/linux)