cmake_minimum_required(VERSION 4.0)
project(kmp_ge C)

set(CMAKE_C_STANDARD 11)

include_directories(core/c/include)
include_directories(core/c/include/kmp_ge)

add_library(
        kmp_ge
        core/c/include/kmp_ge/kmp_ge.c
        core/c/include/kmp_ge/kmp_ge.h
        core/c/include/linearmaths.h
        core/c/include/glad/glad/gl.h
        core/c/include/glad/KHR/khrplatform.h
)