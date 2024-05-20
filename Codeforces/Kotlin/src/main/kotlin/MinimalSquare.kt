package problems

// Problem Link: https://codeforces.com/problemset/problem/1360/A

fun main() {
    var tests = readln().toInt()

    while (tests-- > 0) {
        val (a, b) = readln().split(" ").map { it.toInt() }.sorted()

        println(
            if (a * 2 <= b) b * b
            else a * a * 4
        )
    }
}