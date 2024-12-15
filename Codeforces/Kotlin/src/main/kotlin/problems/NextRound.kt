package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/158/A */

fun main() {
    val inputs = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    var count = 0

    for (score in list) {
        if (score >= list[inputs[1] - 1] && score > 0) count++
    }

    print(count)
}