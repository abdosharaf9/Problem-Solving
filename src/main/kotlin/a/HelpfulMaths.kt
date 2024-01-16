package a

/* Problem Link: https://codeforces.com/problemset/problem/339/A */

fun main() {
    val calculation = readln()
    val numbers = calculation.split("+").sorted()
    numbers.forEachIndexed { index, s ->
        print(s)
        if (index != numbers.size - 1) print("+")
    }
}