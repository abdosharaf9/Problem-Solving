package problems

/* Problem Link: https://codeforces.com/problemset/problem/155/A */

fun main() {
    readln()
    val records = readln().split(" ").map { it.toInt() }
    var maxRecord = records[0]
    var minRecord = records[0]
    var amazing = 0

    for (i in 1..<records.size) {
        if (records[i] > maxRecord) {
            maxRecord = records[i]
            amazing++
        }
        if (records[i] < minRecord) {
            minRecord = records[i]
            amazing++
        }
    }

    print(amazing)
}