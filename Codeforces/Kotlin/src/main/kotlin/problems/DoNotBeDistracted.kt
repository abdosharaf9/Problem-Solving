package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/1520/A */

fun main() {
    var tests = readln().toInt()

    while (tests-- > 0) {
        val n = readln().toInt()
        val days = readln()
        val visited = mutableMapOf<Char, Boolean>()
        var distracted = false

        for (i in 1..<n) {
            if (days[i] != days[i - 1]) visited[days[i - 1]] = true
            if (visited[days[i]] == true) {
                distracted = true
                break
            }
        }

        println(
            if (distracted) "NO"
            else "YES"
        )
    }
}