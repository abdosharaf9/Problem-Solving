package problems

/* Problem Link: https://codeforces.com/problemset/problem/758/A */

fun main() {
    val n = readln()
    val welfare = readln().split(" ").map { it.toInt() }
    val max = welfare.max()
    var sum = 0

    welfare.forEach {
        sum += max - it
    }

    print(sum)
}