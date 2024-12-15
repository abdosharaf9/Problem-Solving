package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/148/A */

fun main() {
    val k = readln().toInt()
    val l = readln().toInt()
    val m = readln().toInt()
    val n = readln().toInt()
    val d = readln().toInt()
    var count = 0

    if (k == 1 || l == 1 || m == 1 || n == 1) {
        print(d)
    } else {
        for (i in 1..d) {
            if ((i % k != 0) && (i % l != 0) && (i % m != 0) && (i % n != 0)) count++
        }
        print(d - count)
    }
}