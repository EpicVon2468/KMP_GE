#! /bin/bash

# 'head' part trims trailing newline

chmod +x ./genIndexOperatorsNative.sh
./genIndexOperatorsNative.sh | head -c -1 > MultiplatformInteropGen.native.kt