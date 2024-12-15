package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/1676/A */

fun main() {
    val tests = readln().toInt()
    for (i in 1..tests) {
        val ticket = readln().toInt()
        val leftPart = ticket / 100000 + ticket % 100000 / 10000 + ticket % 10000 / 1000
        val rightPart = ticket % 1000 / 100 + ticket % 100 / 10 + ticket % 10

        println(
            if (leftPart == rightPart) "YES"
            else "NO"
        )
    }
}
