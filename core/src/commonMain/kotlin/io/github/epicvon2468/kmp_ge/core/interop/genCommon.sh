#! /bin/bash

# 'head' part trims trailing newline

chmod +x ./genIndexOperators.sh
./genIndexOperators.sh | head -c -1 > MultiplatformInteropGen.kt