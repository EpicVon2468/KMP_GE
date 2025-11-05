#! /bin/bash

function gen {
	echo "actual inline operator fun <T : ${1}VarOf<*>> Ptr<T>?.plus(index: Long): Ptr<T>? = this + index"
}

echo "@file:OptIn(ExperimentalForeignApi::class)"
echo "@file:Suppress(\"NOTHING_TO_INLINE\", \"FINAL_UPPER_BOUND\", \"ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT\")"
echo "package io.github.epicvon2468.kmp_ge.core.interop"
echo
echo "import kotlinx.cinterop.ExperimentalForeignApi"
echo "import kotlinx.cinterop.plus"
echo

gen Byte
echo
gen UByte
echo
gen Int
echo
gen UInt
echo
gen Float