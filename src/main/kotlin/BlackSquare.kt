package problems

/* Problem Link: https://codeforces.com/problemset/problem/431/A */

fun main() {
    val (a1, a2, a3, a4) = readln().split(" ").map { it.toInt() }
    var sum = 0
    readln().forEach {
        when (it) {
            '1' -> sum += a1
            '2' -> sum += a2
            '3' -> sum += a3
            '4' -> sum += a4
        }
    }
    print(sum)
}