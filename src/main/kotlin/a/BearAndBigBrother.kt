package a

/* Problem Link: https://codeforces.com/problemset/problem/791/A */

fun main() {
    var (a, b) = readln().split(" ").map { it.toInt() }
    var years = 0

    while (a <= b) {
        years++
        a *= 3
        b *= 2
    }

    print(years)
}