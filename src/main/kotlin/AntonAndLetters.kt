package problems

/* Problem Link: https://codeforces.com/problemset/problem/443/A */

fun main() {
    val letters = readln().drop(1).dropLast(1)
    print(if (letters.isEmpty()) 0 else letters.split(", ").toSet().size)
}