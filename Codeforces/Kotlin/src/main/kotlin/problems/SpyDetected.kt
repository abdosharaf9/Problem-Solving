package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/1512/A */

fun main() {
    val tests = readln().toInt()

    for (i in 1..tests) {
        val n = readln().toInt()
        val numbers = readln().split(" ")

        if (numbers[0] != numbers[1] && numbers[0] != numbers[2]) {
            println(1)
            continue
        } else if (numbers[n - 1] != numbers[n - 2] && numbers[n - 1] != numbers[n - 3]) {
            println(n)
            continue
        } else {
            for (j in 1..<n - 1) {
                if (numbers[j] != numbers[j - 1] && numbers[j] != numbers[j + 1]) {
                    println(j + 1)
                    break
                }
            }
        }
    }
}