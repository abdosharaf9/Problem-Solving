package problems.ShortestCommonSupersequence

// https://leetcode.com/problems/shortest-common-supersequence/

private class Solution {
    // Bottom-Up DP solution to optimize the memory.
    // Time: O(n * m * (n + m)), where n is the length of the str1, and m is the length of
    // str2. The O(n + m) part comes from slicing and concatenating the strings
    // Space: O(n * (n + m)), because we just store two rows at a time, not the whole matrix.
    fun shortestCommonSupersequence(str1: String, str2: String): String {
        // Get the strings' sizes.
        val n = str1.length
        val m = str2.length

        // Initialize the current and previous rows. The previous row is initialized as the
        // postfixes of str2, and the cur row initially is empty, and we will populate it.
        // Note that we added an empty string to avoid index out of bounds.
        var prev = Array(m) { str2.substring(it) } + ""
        var cur = Array(m) { "" }

        // Loop in backwards to build the problem in bottom-up approach.
        for (i in n - 1 downTo 0) {
            // The cur row will be empty, and add the postfix of str1 starting at the current
            // row index as additional string.
            cur = Array(m) { "" } + str1.substring(i)

            for (j in m - 1 downTo 0) {
                if (str1[i] == str2[j]) {
                    // If both current characters are equal, choose any of them, and use the
                    // diagonal cell to fill the current one.
                    cur[j] = str1[i] + prev[j + 1]
                } else {
                    // If they are not equal, choose the minimum string. For str1, we go down, and
                    // for str2, we go right.
                    val res1 = str1[i] + prev[j]
                    val res2 = str2[j] + cur[j + 1]

                    // Choose the minimum string.
                    if (res1.length <= res2.length) {
                        cur[j] = res1
                    } else {
                        cur[j] = res2
                    }
                }
            }

            // The current row will be the previous row in the next iteration.
            prev = cur
        }

        // The first cell will be the answer as it was built using the rest subproblems.
        return cur[0]
    }

    // Top-Down DP solution that gives MLE.
    // Time: O(n * m * (n + m)), where n is the length of the str1, and m is the length of
    // str2. The O(n + m) part comes from slicing and concatenating the strings
    // Space: O(n * m * (n + m)), because we store all the cases in this approach.
    /*fun shortestCommonSupersequence(str1: String, str2: String): String {
        // Cache the results.
        val cache = mutableMapOf<Pair<Int, Int>, String>()

        fun backtrack(i: Int, j: Int): String {
            // Return the pre-computed result.
            if (cache.contains(i to j)) {
                return cache[i to j]!!
            }

            // If we reach str1 end, take the rest of str2.
            if (i == str1.length) {
                return str2.substring(j)
            }

            // If we reach str2 end, take the rest of str1.
            if (j == str2.length) {
                return str1.substring(i)
            }

            // If the current characters are equal, choose any one of them, and increase both pointers.
            if (str1[i] == str2[j]) {
                return str1[i] + backtrack(i + 1, j + 1)
            }

            // Try to choose the character from str1, and the character from str2 and see
            // which way will give us the minimum string to use.
            val res1 = str1[i] + backtrack(i + 1, j)
            val res2 = str2[j] + backtrack(i, j + 1)

            // Use the first result if it is minimum.
            if (res1.length <= res2.length) {
                cache[i to j] = res1
                return res1
            }

            // Use the second result if it is minimum.
            cache[i to j] = res2
            return res2
        }

        // Solve the problem starting from the first character of each string.
        return backtrack(0, 0)
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.shortestCommonSupersequence("abac", "cab"))
    println(sol.shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"))
}