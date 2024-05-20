package problems

// Problem Link: https://codeforces.com/problemset/problem/1873/A

fun main() {
    val cases = mapOf(
        "abc" to "YES",
        "acb" to "YES",
        "bac" to "YES",
        "cba" to "YES",
        "cab" to "NO",
        "bca" to "NO"
    )
    var tests = readln().toInt()

    while (tests-- > 0) {
        val case = readln()
        println(cases[case])
    }
}