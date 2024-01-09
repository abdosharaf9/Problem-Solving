package utils

fun readString() = readln()

fun readInt() = readString().toInt()

fun readDouble() = readString().toDouble()

fun readFloat() = readString().toFloat()

fun readBoolean() = readString().toBoolean()

fun readStrings() = readString().split(" ")

fun readInts() = readStrings().map { it.toInt() }

fun readDoubles() = readStrings().map { it.toDouble() }

fun readFloats() = readStrings().map { it.toFloat() }

fun readBooleans() = readStrings().map { it.toBoolean() }