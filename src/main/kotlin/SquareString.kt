package problems

// Problem Link: https://codeforces.com/problemset/problem/1619/A

fun main() {
    var tests = readln().toInt()

    while (tests-- > 0) {
        val string = readln()

        println(
            if (string.length % 2 == 1) "NO"
            else if (string.substring(0, string.length / 2) == string.substring(string.length / 2)) "YES"
            else "NO"
        )
    }
}
