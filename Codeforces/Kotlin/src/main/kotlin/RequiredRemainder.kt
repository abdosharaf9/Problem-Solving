package problems

/* Problem Link: https://codeforces.com/problemset/problem/1374/A */

fun main() {
    var tests = readln().toInt()

    while (tests-- > 0) {
        val (x, y, n) = readln().split(" ").map { it.toInt() }
        val ans = n - n % x + y

        println(
            if (ans <= n) ans else n - n % x - (x - y)
        )
    }
}