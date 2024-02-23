package problems

/* Problem Link: https://codeforces.com/problemset/problem/510/A */

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    var start = true

    for (i in 1..n) {
        if (i % 2 != 0) start = !start

        for (j in 1..m) {
            if (i % 2 != 0) {
                print('#')
            } else if (j != 1 && j != m) print('.')
            else if (start && j == 1) print('#')
            else if (!start && j == m) print('#')
            else print('.')
        }

        println()
    }
}