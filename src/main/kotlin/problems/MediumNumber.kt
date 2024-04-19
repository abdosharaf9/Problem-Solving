package problems

// Problem Link: https://codeforces.com/problemset/problem/1760/A

fun main() {
    var tests = readln().toInt()
    while (tests-- > 0) {
        println(readln().split(" ").map { it.toInt() }.sorted()[1])
    }
}