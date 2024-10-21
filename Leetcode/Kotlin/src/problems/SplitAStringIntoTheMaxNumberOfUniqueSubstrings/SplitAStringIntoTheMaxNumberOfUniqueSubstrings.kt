package problems.SplitAStringIntoTheMaxNumberOfUniqueSubstrings

import kotlin.math.max

// https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/

private class Solution {
    fun maxUniqueSplit(s: String): Int {
        val visited = mutableSetOf<String>()

        fun solve(idx: Int): Int {
            if (idx == s.length) return 0

            var result = 0
            for (i in idx..s.lastIndex) {
                val cur = s.substring(idx, i + 1)
                if (cur in visited) continue

                visited.add(cur)
                result = max(result, 1 + solve(i + 1))
                visited.remove(cur)
            }

            return result
        }

        return solve(0)
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxUniqueSplit("ababccc"))
    println(sol.maxUniqueSplit("aba"))
    println(sol.maxUniqueSplit("aa"))
}