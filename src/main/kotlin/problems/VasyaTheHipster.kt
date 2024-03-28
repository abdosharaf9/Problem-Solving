package problems

/* Problem Link: https://codeforces.com/problemset/problem/581/A */

fun main() {
    val (red, blue) = readln().split(" ").map { it.toInt() }
    print("${if (red < blue) red else blue} ${if (red < blue) (blue - red) / 2 else (red - blue) / 2}")
}