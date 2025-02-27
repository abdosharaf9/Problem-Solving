package problems.LengthOfLongestFibonacciSubsequence

// https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/

private class Solution {
    // Time: between O(n^2) and O(n^3). We can say it is O(n^2 * log m), where
    // m is the largest number in the array.
    // Space: O(n)
    fun lenLongestFibSubseq(arr: IntArray): Int {
        // Store the numbers in a set to access them in O(1) time.
        val set = HashSet<Int>()
        for (n in arr) {
            set.add(n)
        }

        var res = 0

        // Try each pair as the starting of the sequence.
        for (i in 0..<arr.lastIndex) {
            for (j in i + 1..arr.lastIndex) {
                // Our initial starting numbers are arr[i] and arr[j], and the
                // next number will be their summation.
                var prev = arr[i]
                var cur = arr[j]
                var next = prev + cur

                // The initial length of any sequence.
                var length = 2

                // Loop until we can't go further in the current sequence
                // (the next number doesn't exist in the array).
                while (set.contains(next)) {
                    // Increase the sequence length, and maximize the result.
                    length++
                    res = maxOf(res, length)

                    // Move forward in the sequence.
                    prev = cur
                    cur = next
                    next = prev + cur
                }
            }
        }

        return res
    }

    // Time: O(n^2)
    // Space: O(n^2)
    /*fun lenLongestFibSubseq(arr: IntArray): Int {
        // Map each number to its index.
        val map = HashMap<Int, Int>()
        for (i in arr.indices) {
            map[arr[i]] = i
        }

        // Store the value of each subproblem, where dp[i][j] means the length
        // of the longest sequence we can form using i and j as our starting.
        val dp = Array(arr.size) { IntArray(arr.size) }
        var res = 0

        // Try each pair as the starting of the sequence. Loop in reversed
        // order to build the subproblems.
        for (i in arr.lastIndex - 1 downTo 0) {
            for (j in arr.lastIndex downTo i + 1) {
                // Our starting numbers are arr[i] and arr[j], and the next number will be their summation.
                val next = arr[i] + arr[j]

                // The initial length of any sequence.
                var length = 2

                // If the next number is presented in the array.
                if (map.contains(next)) {
                    // Get the length of the sequence starting with the current second starting
                    // number (which is arr[j]) and the next number (which is `next`), and add 1
                    // to it (the first starting number arr[i]).
                    length = 1 + dp[j][map[next]!!]

                    // Maximize the result.
                    res = maxOf(res, length)
                }

                // Store the result for the current problem.
                dp[i][j] = length
            }
        }

        return res
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.lenLongestFibSubseq(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)))
    println(sol.lenLongestFibSubseq(intArrayOf(1, 3, 7, 11, 12, 14, 18)))
}