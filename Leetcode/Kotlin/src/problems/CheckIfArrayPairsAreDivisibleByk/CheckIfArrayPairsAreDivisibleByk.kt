package problems.CheckIfArrayPairsAreDivisibleByk

// https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/

private class Solution {
    fun canArrange(arr: IntArray, k: Int): Boolean {
        val freq = IntArray(k) { 0 }
        for (x in arr) {
            freq[((x % k) + k) % k]++
        }

        if (freq[0] % 2 != 0) return false

        for (i in 1..k / 2) {
            if (freq[i] != freq[k - i]) return false
        }

        return true
    }
}

fun main() {
    val sol = Solution()
    println(sol.canArrange(intArrayOf(1, 2, 3, 4, 5, 10, 6, 7, 8, 9), 5))
    println(sol.canArrange(intArrayOf(1, 2, 3, 4, 5, 6), 7))
    println(sol.canArrange(intArrayOf(1, 2, 3, 4, 5, 6), 10))
}