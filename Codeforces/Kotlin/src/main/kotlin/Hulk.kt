package problems

/* Problem Link: https://codeforces.com/problemset/problem/705/A */

fun main() {
    val n = readln().toInt()

    for (i in 0..<n) {
        if (i == n - 1) {
            if (i % 2 == 0) print("I hate it")
            else print("I love it")
        } else {
            if (i % 2 == 0) print("I hate that ")
            else print("I love that ")
        }
    }
}