package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/231/A */

fun main() {
    val n = readln().toInt()
    var count = 0

    for(test in 1..n) {
        val votes = readln().split(" ").map { it.toInt() }

        if(votes[0] + votes[1] + votes[2] >= 2) {
            count++
        }
    }

    print(count)
}