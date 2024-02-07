package problems

/* Problem Link: https://codeforces.com/problemset/problem/59/A */

fun main() {
    val word = readln()
    val upper = word.count { it.isUpperCase() }
    val lower = word.length - upper

    print(if (upper > lower) word.uppercase() else word.lowercase())
}