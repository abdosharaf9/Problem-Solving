package problems

// Problem Link: https://codeforces.com/problemset/problem/1915/A

fun main() {
    var tests = readln().toInt()

    while (tests-- > 0) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }

        println(
            when (a) {
                b -> c
                c -> b
                else -> a
            }
        )
    }
}