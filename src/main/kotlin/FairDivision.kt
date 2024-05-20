package problems

// Problem Link: https://codeforces.com/problemset/problem/1472/B

fun main() {
    var tests = readln().toInt()

    while (tests-- > 0) {
        val n = readln()
        val candies = readln().split(" ").map { it.toInt() }

        val count1 = candies.count { it == 1 }
        val count2 = candies.count { it == 2 }
        val total = count1 + 2 * count2

        println(
            if (total % 2 != 0) "NO"
            else if ((total / 2) % 2 == 0 || count1 != 0) "YES"
            else "NO"
        )
    }
}