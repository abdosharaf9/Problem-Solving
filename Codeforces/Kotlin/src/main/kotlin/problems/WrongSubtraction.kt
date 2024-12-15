package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/977/A */

fun main() {
    var (n, k) = readln().split(" ").map { it.toInt() }

    for (i in 1..k) {
        if (n % 10 == 0) n /= 10
        else n -= 1
    }

    print(n)
}