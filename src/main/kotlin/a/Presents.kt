package a

/* Problem Link: https://codeforces.com/problemset/problem/136/A */

fun main() {
    val n = readln().toInt()
    val friends = readln().split(" ").map { it.toInt() }

    val sortedList = List(friends.size) { index ->
        friends.indexOf(index + 1) + 1
    }

    for(x in sortedList) print("$x ")
}