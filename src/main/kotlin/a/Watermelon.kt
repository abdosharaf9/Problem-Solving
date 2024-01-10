package a

/* Problem Link: https://codeforces.com/problemset/problem/4/A */

fun main() {
    val w = readln().toInt()
    if (w % 2 == 0 && w > 2) print("YES") else print("NO")
}