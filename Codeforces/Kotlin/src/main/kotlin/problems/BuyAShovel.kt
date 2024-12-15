package problems.problems

// Problem Link: https://codeforces.com/problemset/problem/732/A

fun main() {
    val (price, coins) = readln().split(" ").map { it.toInt() }
    var shovels = 1

    while ((shovels * price) % 10 != 0 && (shovels * price) % 10 != coins) {
        shovels++
    }

    print(shovels)
}