cmake_minimum_required(VERSION 4.0)
project(kmp_ge C)

set(CMAKE_C_STANDARD 11)

include_directories(c/include/kmp_ge)

add_library(
        kmp_ge
        c/include/kmp_ge/kmp_ge.c
        c/include/kmp_ge/kmp_ge.h
)

target_include_directories(kmp_ge INTERFACE ${CMAKE_SOURCE_DIR}/c/include/)
target_include_directories(kmp_ge INTERFACE ${CMAKE_SOURCE_DIR}/c/include/glad/)