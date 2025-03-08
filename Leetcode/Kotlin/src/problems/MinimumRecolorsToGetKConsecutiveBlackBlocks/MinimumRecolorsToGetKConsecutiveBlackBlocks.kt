package problems.MinimumRecolorsToGetKConsecutiveBlackBlocks

// https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/

private class Solution {
    // Using Sliding Window to try every window of size k.
    // Time: O(n)
    // Space: O(1)
    fun minimumRecolors(blocks: String, k: Int): Int {
        // Store the number of black blocks in the current window.
        var black = 0

        // The maximum value for the result will be k.
        var res = k
        var left = 0
        for (r in 0..blocks.lastIndex) {
            // Increase the number of black blocks in the current window.
            if (blocks[r] == 'B') {
                black++
            }

            // If the current window is of size k, update the result.
            if (r - left + 1 == k) {
                res = minOf(res, k - black)

                // Shift the left pointer, and update the number of black blocks if is needed.
                if (blocks[left] == 'B') {
                    black--
                }

                left++
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.minimumRecolors("WBBWWBBWBW", 7))
    println(sol.minimumRecolors("WBWBBBW", 2))
}