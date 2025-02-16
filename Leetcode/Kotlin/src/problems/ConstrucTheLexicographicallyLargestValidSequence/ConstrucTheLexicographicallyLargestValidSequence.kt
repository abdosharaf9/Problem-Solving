package problems.ConstrucTheLexicographicallyLargestValidSequence

import utils.printArray

// https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/

private class Solution {
    // Time: O(n!), due to backtracking over all valid permutations.
    // Space: O(n), because we use an array to store the visited numbers.
    fun constructDistancedSequence(n: Int): IntArray {
        // Initialize the result array in which all the numbers rather than 1 will occur twice.
        val res = IntArray(n * 2 - 1)

        // Keep track of visited numbers.
        val used = BooleanArray(n + 1)

        // Try to add the biggest unvisited number in the current index, and
        // also assign the second occurrence of that number and check if it will
        // work, or we need to backtrack.
        fun backtrack(i: Int): Boolean {
            // When we reach the last index, thus we have populated the array.
            if (i == res.size) {
                return true
            }

            // Try the largest numbers to make sure we will generate the
            // lexicographically largest sequence without trying too much.
            for (num in n downTo 1) {
                // Avoid visiting the same number again.
                if (used[num]) {
                    continue
                }

                // All the numbers other than 1 will appear twice, and the difference between
                // both the occurrences must be equal to the number itself. Here we check if we
                // used this index, will the index of the second occurrence be available.
                if (num > 1 && (i + num >= res.size || res[i + num] > 0)) {
                    continue
                }

                // Try to make the decision and use this index, and also use the index of the
                // second occurrence if the number is not 1. Also, mark the number as visited.
                used[num] = true
                res[i] = num
                if (num > 1) {
                    res[i + num] = num
                }

                // Find the next available index.
                var j = i + 1
                while (j < res.size && res[j] > 0) {
                    j++
                }

                // If we can populate the array after this decision, end the function.
                if (backtrack(j)) {
                    return true
                }

                // If we can't populate the array after this decision, backtrack and don't
                // use this index for this number, and also remove it from the visited numbers.
                used[num] = false
                res[i] = 0
                if (num > 1) {
                    res[i + num] = 0
                }
            }

            // We will reach here if we can't populate the array using the previous decision.
            return false
        }

        // Assign value for the first index.
        backtrack(0)

        // Return the result array after populating it.
        return res
    }
}

fun main() {
    val sol = Solution()
    printArray(sol.constructDistancedSequence(3))
    printArray(sol.constructDistancedSequence(5))
}