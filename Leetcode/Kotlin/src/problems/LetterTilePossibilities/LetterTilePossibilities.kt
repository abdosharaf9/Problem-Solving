package problems.LetterTilePossibilities

// https://leetcode.com/problems/letter-tile-possibilities/

private class Solution {
    // Time: Lies somewhere between O(2^n) and O(n!), depending on character repetitions.
    // Space: O(n)
    fun numTilePossibilities(tiles: String): Int {
        // Store the count of each character.
        val counts = IntArray(26)
        for (c in tiles) {
            counts[c - 'A']++
        }

        // Count the number of ways we can form a permutation using each character in each position.
        fun backtrack(): Int {
            var res = 0
            for (i in counts.indices) {
                // Use the existed characters.
                if (counts[i] > 0) {
                    // Use the current character.
                    counts[i]--

                    // Count the permutations after this decision.
                    res += backtrack() + 1

                    // Backtrack and try another character.
                    counts[i]++
                }
            }

            return res
        }

        return backtrack()
    }
}

fun main() {
    val sol = Solution()
    println(sol.numTilePossibilities("AAB"))
    println(sol.numTilePossibilities("AAABBC"))
    println(sol.numTilePossibilities("V"))
}