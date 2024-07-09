// Problem Link: https://leetcode.com/problems/score-of-a-string

import kotlin.math.abs

fun scoreOfString(s: String): Int {
    var score = 0

    for (i in 0..s.length - 2) {
        score += abs(s[i].code - s[i+1].code)
    }

    return score
}

fun main() {
    print(scoreOfString(s = "zaz"))
}