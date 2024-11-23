package utils

fun printArray(arr: IntArray, newLine: Boolean = true) {
    print("[")

    for (i in arr.indices) {
        print("${arr[i]}")
        if (i != arr.lastIndex) print(", ")
    }

    print("]${if (newLine) "\n" else ""}")
}

fun printArray(arr: CharArray, newLine: Boolean = true) {
    print("[")

    for (i in arr.indices) {
        print("${arr[i]}")
        if (i != arr.lastIndex) print(", ")
    }

    print("]${if (newLine) "\n" else ""}")
}

fun printArray(arr: Array<String>, newLine: Boolean = true) {
    print("[")

    for (i in arr.indices) {
        print(arr[i])
        if (i != arr.lastIndex) print(", ")
    }

    print("]${if (newLine) "\n" else ""}")
}

fun printMatrixLikeMatrix(matrix: Array<IntArray>) {
    print("[")

    for (i in matrix.indices) {
        printArray(matrix[i], false)
        if (i != matrix.lastIndex) println(", ")
    }

    println("]")
}

fun printMatrixLikeMatrix(matrix: Array<CharArray>) {
    print("[")

    for (i in matrix.indices) {
        printArray(matrix[i], false)
        if (i != matrix.lastIndex) println(", ")
    }

    println("]")
}

fun printMatrixLikeArray(matrix: Array<IntArray>) {
    print("[")

    for (i in matrix.indices) {
        printArray(matrix[i], false)
        if (i != matrix.lastIndex) print(", ")
    }

    println("]")
}