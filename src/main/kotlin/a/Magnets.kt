package a

/* Problem Link: https://codeforces.com/problemset/problem/344/A */

fun main() {
    val n = readln().toInt()
    val magnets = mutableListOf<String>()
    var groups = 1

    for (i in 0..<n) {
        val x = readln()
        magnets.add(x)
        if (i > 0 && magnets[i] != magnets[i - 1]) groups += 1
    }

    print(groups)
}