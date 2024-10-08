package problems.MinimumNumberOfSwapsToMakeTheStringBalanced

// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/

private class Solution {
    fun minSwaps(s: String): Int {
        var result = 0
        var opens = 0

        for (i in s.indices) {
            if (s[i] == '[') opens++
            else if (opens == 0) result++
            else opens--
        }

        return (result + 1) / 2
    }
}

fun main() {
    val sol = Solution()
    println(sol.minSwaps("][]["))
    println(sol.minSwaps("]]][[["))
    println(sol.minSwaps("[]"))
}