package problems.MaximumNumberOfBalloons

// https://leetcode.com/problems/maximum-number-of-balloons/

private class Solution {
    fun maxNumberOfBalloons(text: String): Int {
        val count = IntArray(26) { 0 }
        for (c in text) {
            count[c - 'a']++
        }

        return minOf(
            count['b' - 'a'],
            count['a' - 'a'],
            count['l' - 'a'] / 2,
            count['o' - 'a'] / 2,
            count['n' - 'a']
        )
    }

    /*fun maxNumberOfBalloons(text: String): Int {
        val count = mutableMapOf<Char, Int>()
        for (c in text) {
            count[c] = count.getOrPut(c) { 0 } + 1
        }

        return minOf(
            count.getOrDefault('b', 0),
            count.getOrDefault('a', 0),
            count.getOrDefault('l', 0) / 2,
            count.getOrDefault('o', 0) / 2,
            count.getOrDefault('n', 0)
        )
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.maxNumberOfBalloons("nlaebolko"))
    println(sol.maxNumberOfBalloons("loonbalxballpoon"))
    println(sol.maxNumberOfBalloons("leetcode"))
}