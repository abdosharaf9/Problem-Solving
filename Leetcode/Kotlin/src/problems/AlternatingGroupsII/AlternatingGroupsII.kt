package problems.AlternatingGroupsII

// https://leetcode.com/problems/alternating-groups-ii/

private class Solution {
    // Using Sliding Window to check every window of size k.
    // Time: O(n)
    // Space: O(1)
    fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
        val n = colors.size
        var left = 0
        var res = 0

        // Loop over all the windows of size k to check if it is a valid alternate group.
        // Note that the array is considered circular, so we need to loop more than n to
        // get the first k-1 items in our consideration. For example, if we have this
        // array [0,1,0,1,0] of size 5 and k = 3, the last window will start at index n-1
        // and end at index 1 (indices involved in the window: n-1, 0, 1). Thus, at most
        // we need to get the first k-1 numbers, so loop until n + k - 2 which comes from
        // (n-1) + (k-1) = n + k - 2.
        for (r in 1..n + k - 2) {
            // If the next number doesn't alternate, then we can't form any valid window
            // that involves these two numbers, so jump directly to start a new window at
            // the next number.
            if (colors[r % n] == colors[(r - 1) % n]) {
                left = r
            }

            // If the current window is of size k, increase the result and
            // the left pointer to start a new window.
            if (r - left + 1 == k) {
                res++
                left++
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.numberOfAlternatingGroups(intArrayOf(0, 1, 0, 1, 0), 3))
    println(sol.numberOfAlternatingGroups(intArrayOf(0, 1, 0, 0, 1, 0, 1), 6))
    println(sol.numberOfAlternatingGroups(intArrayOf(1, 1, 0, 1), 4))
}