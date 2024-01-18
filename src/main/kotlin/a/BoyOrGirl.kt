package a

/* Problem Link: https://codeforces.com/problemset/problem/236/A */

fun main() {
    val name = readln()
    print(if (name.toSet().size % 2 == 0) "CHAT WITH HER!" else "IGNORE HIM!")
}