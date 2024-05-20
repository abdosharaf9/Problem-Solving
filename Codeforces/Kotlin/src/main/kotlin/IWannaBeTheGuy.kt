package problems

/* Problem Link: https://codeforces.com/problemset/problem/469/A */

fun main() {
    val n = readln().toInt()
    val levels = mutableSetOf<String>()
    val x = readln().split(" ")
    if (x.size > 1) levels.addAll(x.drop(1))

    val y = readln().split(" ")
    if (y.size > 1) levels.addAll(y.drop(1))

    print(if (levels.size == n) "I become the guy." else "Oh, my keyboard!")
}