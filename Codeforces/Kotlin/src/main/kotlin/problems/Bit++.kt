package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/282/A */

fun main() {
    val n = readln().toInt()
    var x = 0

    for (test in 1..n) {
        val statement = readln()

        if(statement.contains("++")) x++
        else x--
    }

    print(x)
}