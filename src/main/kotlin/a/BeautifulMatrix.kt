package a

import kotlin.math.abs

/* Problem Link: https://codeforces.com/problemset/problem/263/A */

fun main() {
    repeat(5) { row ->
        readln().split(" ").forEachIndexed { column, s ->
            if (s == "1") print(abs(row - 2) + abs(column - 2))
        }
    }
}