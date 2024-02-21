package problems

/* Problem Link: https://codeforces.com/problemset/problem/1335/A */

fun main() {
    val tests = readln().toInt()
    for (i in 1..tests) {
        val n = readln().toInt()
        println(if (n < 3) 0 else if (n % 2 == 0) n / 2 - 1 else n / 2)
    }
}