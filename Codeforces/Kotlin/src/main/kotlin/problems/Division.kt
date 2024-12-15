package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/1669/A */

fun main() {
    var tests = readln().toInt()

    while (tests-- > 0) {
        val rating = readln().toInt()

        println(
            when {
                rating <= 1399 -> "Division 4"
                rating <= 1599 -> "Division 3"
                rating <= 1899 -> "Division 2"
                else -> "Division 1"
            }
        )
    }
}