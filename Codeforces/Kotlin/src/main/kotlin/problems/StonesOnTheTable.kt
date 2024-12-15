package problems.problems

/* Problem Link: https://codeforces.com/problemset/problem/266/A */

fun main() {
    val n = readln().toInt()
    val stones = readln()
    var number = 0

    for (i in 0..stones.length - 2) {
        if(stones[i] == stones[i+1]) number ++
    }

    print(number)
}