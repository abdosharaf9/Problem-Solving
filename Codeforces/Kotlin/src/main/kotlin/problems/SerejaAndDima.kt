package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/381/A */

fun main() {
    val n = readln().toInt()
    val cards = readln().split(" ").map { it.toInt() }.toMutableList()
    var sereja = 0
    var dima = 0

    for (i in 1..n) {
        if (cards.first() > cards.last()) {
            if (i % 2 == 1) sereja += cards.first() else dima += cards.first()
            cards.removeFirst()
        } else {
            if (i % 2 == 1) sereja += cards.last() else dima += cards.last()
            cards.removeLast()
        }
    }

    print("$sereja $dima")
}