package problems

/* Problem Link: https://codeforces.com/problemset/problem/427/A */

fun main() {
    val n = readln()
    val events = readln().split(" ").map { it.toInt() }
    var cops = 0
    var result = 0

    events.forEach { event ->
        if (event != -1) cops += event
        else if (cops == 0) result++
        else cops--
    }

    print(result)
}