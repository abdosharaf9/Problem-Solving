package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/61/A */

fun main() {
    val first = readln()
    val second = readln()
    first.forEachIndexed { index, c ->
        print(if (c == second[index]) '0' else '1')
    }
}