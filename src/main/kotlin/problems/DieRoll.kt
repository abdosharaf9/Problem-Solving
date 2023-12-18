package problems

import java.util.Scanner
import kotlin.math.max

/* Problem Link: https://codeforces.com/problemset/problem/9/A */

fun main() {
    val probs = listOf("1/6", "1/3", "1/2", "2/3", "5/6", "1/1")
//    val read = Scanner(System.`in`)
//    val y = read.nextInt()
//    val w = read.nextInt()
    val (y, w) = readln().split(" ").map { it.toInt() }
    print(probs[6 - max(y, w)])

}