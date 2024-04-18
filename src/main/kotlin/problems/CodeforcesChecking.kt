package problems

// Problem Link: https://codeforces.com/problemset/problem/1791/A

fun main() {
    var tests = readln().toInt()

    while (tests-- > 0) {
        println(
            if ("codeforces".contains(readln())) "YES"
            else "NO"
        )
    }
}