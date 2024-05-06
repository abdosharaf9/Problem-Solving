package problems

// Problem Link: https://codeforces.com/problemset/problem/1283/A

fun main() {
    var tests = readln().toInt()

    while (tests-- > 0) {
        val (hours, minutes) = readln().split(" ").map { it.toInt() }

        val minutesBefore = when (minutes) {
            0 -> {
                (24 - hours) * 60
            }

            else -> {
                ((23 - hours) * 60) + (60 - minutes)
            }
        }

        println(minutesBefore)
    }
}