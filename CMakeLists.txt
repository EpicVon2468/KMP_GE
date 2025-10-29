cmake_minimum_required(VERSION 4.0)
project(KMP_GE C)

set(CMAKE_C_STANDARD 11)

include_directories(core/c/include)
include_directories(core/c/include/kmp_ge)

add_library(KMP_GE
        core/c/include/kmp_ge/kmp_ge.c
        core/c/include/kmp_ge/kmp_ge.h)