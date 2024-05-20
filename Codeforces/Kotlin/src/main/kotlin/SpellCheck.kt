package problems

// Problem Link: https://codeforces.com/problemset/problem/1722/A

fun main() {
    var tests = readln().toInt()

    while (tests-- > 0) {
        val n = readln().toInt()
        val string = readln()

        println(
            if (n == 5 && string.toCharArray().sorted().joinToString("") == "Timru") "YES"
            else "NO"
        )
    }
}