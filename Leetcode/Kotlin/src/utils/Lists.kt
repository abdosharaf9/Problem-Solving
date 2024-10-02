package utils

fun printList(list: List<Int>) {
    print("[")

    for (i in list.indices) {
        print("${list[i]}")
        if (i != list.lastIndex) print(", ")
    }

    println("]")
}