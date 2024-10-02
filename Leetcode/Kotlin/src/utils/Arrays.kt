package utils

fun printArray(arr: IntArray) {
    print("[")

    arr.forEachIndexed { idx, x ->
        print("$x")
        if (idx != arr.lastIndex) print(", ")
    }

    println("]")
}