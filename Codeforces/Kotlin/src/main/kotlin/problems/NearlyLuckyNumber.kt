package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/110/A */

fun main() {
    val n = readln()
    val lucky = n.count { it == '4' || it == '7' }.toString()
    val isNearlyLucky = lucky.count { it == '4' || it == '7' }
    print(if(lucky.length == isNearlyLucky) "YES" else "NO")
}