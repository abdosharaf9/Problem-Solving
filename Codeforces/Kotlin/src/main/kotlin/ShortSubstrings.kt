package problems

// Problem Link: https://codeforces.com/problemset/problem/1367/A

fun main() {
    var tests = readln().toInt()

    while (tests-- > 0) {
        val stringB = readln()
        var stringA = stringB.substring(0, 2)

        for (i in 2..<stringB.length) {
            if (i % 2 != 0) stringA += stringB[i]
        }

        println(stringA)
    }
}