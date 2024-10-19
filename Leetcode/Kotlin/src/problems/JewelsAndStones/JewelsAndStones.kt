package problems.JewelsAndStones

import kotlin.system.measureTimeMillis

// https://leetcode.com/problems/jewels-and-stones/

private class Solution {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        val jewelsMp = mutableMapOf<Char, Boolean>()
        for (jewel in jewels) {
            jewelsMp[jewel] = true
        }

        var result = 0
        for (stone in stones) {
            if (jewelsMp.getOrDefault(stone, false)) result++
        }

        return result

    }
}

fun main() {
    val sol = Solution()
    println(sol.numJewelsInStones("aA", "aAAbbbb"))
    println(sol.numJewelsInStones("z", "ZZ"))
}