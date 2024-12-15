package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/520/A */

fun main() {
    val length = readln()
    val word = readln().lowercase().toCharArray().toSet()
    print(if (word.size == 26) "YES" else "NO")
}