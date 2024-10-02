package utils

fun printArray(arr: IntArray) {
    print("[")

    for (i in arr.indices) {
        print("${arr[i]}")
        if (i != arr.lastIndex) print(", ")
    }

    println("]")
}

fun printArray(arr: Array<String>) {
    print("[")

    for (i in arr.indices) {
        print(arr[i])
        if (i != arr.lastIndex) print(", ")
    }

    println("]")
}