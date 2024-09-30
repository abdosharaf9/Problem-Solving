package KotlinHeroesEpisode11

import kotlin.math.max
import kotlin.math.min

// https://codeforces.com/contest/2011/problem/A

fun main() {
    var tests = readln().toInt()

    while (tests != 0) {
        readln()
        val list = readln().split(" ").map { it.toInt() }

        var max1 = max(list[0], list[1])
        var max2 = min(list[0], list[1])

        for (i in 2..list.lastIndex) {
            if (list[i] > max1) {
                max2 = max1
                max1 = list[i]
            } else if (list[i] > max2) {
                max2 = list[i]
            }
        }

        println(
            if (max1 - max2 == 1) max2
            else "Ambiguous"
        )

        tests--
    }
}