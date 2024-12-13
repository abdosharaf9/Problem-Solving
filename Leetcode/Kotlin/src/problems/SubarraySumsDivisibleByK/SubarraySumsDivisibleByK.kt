package SubarraySumsDivisibleByK

// https://leetcode.com/problems/subarray-sums-divisible-by-k/

class Solution {
    // Time: O(n), but more faster
    // Space: O(k)
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        // The difference here is that we save the frequencies in an array
        // because we know all the possible remaining numbers which is k (0...k-1).
        // Also, here we don't save the summation, we save only the prefix
        // (remaining) value which is the important thing.
        var result = 0
        var prefix = 0
        val prefixFrequency = IntArray(k) { 0 }
        prefixFrequency[0] = 1

        for (n in nums) {
            // Calculate the current prefix value we need to remove.
            prefix = (prefix + n % k + k) % k

            // Add that frequency to the result.
            result += prefixFrequency[prefix]

            // Update the frequency of the current prefix.
            prefixFrequency[prefix]++
        }

        return result
    }

    // Time: O(n)
    // Space: O(k)
    /*fun subarraysDivByK(nums: IntArray, k: Int): Int {
        // We will see how many frequencies we can subtract from the current
        // summation to get a remainder 0 when mod by k. At the start, we will
        // 0 prefix, so we add it to the map to use it easily.
        var result = 0
        var currentSum = 0L
        val prefixFrequency = mutableMapOf(0 to 1)

        for (n in nums) {
            // Calculate the prefix value we need to remove from the current
            // summation. Then, get its frequency.
            currentSum += n
            val remaining = currentSum.mod(k) // Used for -ve values
            val remainingCount = prefixFrequency.getOrDefault(remaining, 0)

            // Add that frequency to the result, because we can get a remainder
            // 0 when we subtract any one of them from the current summation.
            // So, each one of them is considered as a valid count.
            result += remainingCount

            // Update the frequency of the current remaining.
            prefixFrequency[remaining] = remainingCount + 1
        }

        return result
    }*/
}


fun main() {
    val sol = Solution()
    println(sol.subarraysDivByK(intArrayOf(4, 5, 0, -2, -3, 1), 5))
    println(sol.subarraysDivByK(intArrayOf(5), 9))
    println(sol.subarraysDivByK(intArrayOf(-1, 2, 9), 2))
}