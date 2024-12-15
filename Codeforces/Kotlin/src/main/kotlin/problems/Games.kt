package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/268/A */

fun main() {
    val n = readln().toInt()
    val home = mutableListOf<String>()
    val guest = mutableListOf<String>()
    var result = 0

    for (i in 1..n) {
        val (x, y) = readln().split(" ")
        home.add(x)
        guest.add(y)
    }

    home.forEach { color ->
        result += guest.count { it == color }
    }

    print(result)
}