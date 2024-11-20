package problems.TakeKOfEachCharacterFromLeftAndRight

// https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/

private class Solution {
    fun takeCharacters(s: String, k: Int): Int {
        val counts = IntArray(3) { 0 }
        for (c in s) {
            counts[c - 'a']++
        }
        if (counts.min() < k) return -1

        var res = Int.MAX_VALUE
        var l = 0
        for (r in s.indices) {
            counts[s[r] - 'a']--

            while (counts.min() < k) {
                counts[s[l] - 'a']++
                l++
            }

            res = minOf(res, s.length - (r - l + 1))
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.takeCharacters("aabaaaacaabc", 2))
    println(sol.takeCharacters("a", 1))
}