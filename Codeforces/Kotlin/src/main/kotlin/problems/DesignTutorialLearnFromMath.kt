package problems.problems

import kotlin.math.sqrt

// Problem Link: https://codeforces.com/problemset/problem/472/A

fun main() {
    val number = readln().toInt()

//    print("${8 + number % 2} ${number - 8 - number % 2}")

    for (i in 2..<number) {
        if (isComposite(i) && isComposite(number - i)) {
            print("$i ${number - i}")
            return
        }
    }
}

fun isComposite(n: Int): Boolean {
    if (n < 4) return false

    for (i in 2..sqrt(n.toDouble()).toInt() + 1) {
        if (n % i == 0) return true
    }

    return false
}