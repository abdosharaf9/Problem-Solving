package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/71/A */

fun main() {
    val n = readln().toInt()

    for (test in 1..n) {
        val word = readln()

        if (word.length > 10) {
            println("${word.first()}${word.length - 2}${word.last()}")
        } else {
            println(word)
        }
    }
}