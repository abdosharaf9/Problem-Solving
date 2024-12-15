package problems.problems

import java.util.Scanner

/* Problem Link: https://codeforces.com/problemset/problem/151/A */

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val k = scanner.nextInt()
    val l = scanner.nextInt()
    val c = scanner.nextInt()
    val d = scanner.nextInt()
    val p = scanner.nextInt()
    val nl = scanner.nextInt()
    val np = scanner.nextInt()

    val drinkToasts = (k * l) / nl
    val limeToasts = c * d
    val saltToasts = p / np

    print(minOf(drinkToasts, limeToasts, saltToasts) / n)
}