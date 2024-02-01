package a

/* Problem Link: https://codeforces.com/problemset/problem/271/A */

fun main() {
    var year = readln().toInt()

    do {
        year++
    } while (year.toString().toSet().size < 4)

    print(year)
}