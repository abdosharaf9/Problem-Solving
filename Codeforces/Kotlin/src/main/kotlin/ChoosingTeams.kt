package problems

// Problem Link: https://codeforces.com/problemset/problem/432/A

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val students = readln().split(" ").map { it.toInt() }.filter { (it + k) <= 5 }
    print(students.size / 3)
}