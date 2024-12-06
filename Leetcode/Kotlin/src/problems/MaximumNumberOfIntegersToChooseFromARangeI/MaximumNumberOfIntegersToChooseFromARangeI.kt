package problems.MaximumNumberOfIntegersToChooseFromARangeI

// https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/

private class Solution {
    // Time: O(n)
    // Space: O(1)
    fun maxCount(banned: IntArray, n: Int, maxSum: Int): Int {
        // Add banned numbers to a set to access them in O(1)
        val bannedSet = mutableSetOf<Int>()
        for (x in banned) {
            if (x <= n) bannedSet.add(x)
        }

        var sum = 0
        var res = 0
        for (i in 1..n) {
            // Can't choose a banned number
            if (bannedSet.contains(i)) {
                continue
            }

            // We must break if the summation will exceed the maxSum
            // because all the numbers after the current will just
            // make the summation bigger
            if (sum + i > maxSum) {
                break
            }

            // Update summation and count
            sum += i
            res++
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxCount(intArrayOf(1, 6, 5), 5, 6))
    println(sol.maxCount(intArrayOf(1, 2, 3, 4, 5, 6, 7), 8, 1))
    println(sol.maxCount(intArrayOf(11), 7, 50))
}