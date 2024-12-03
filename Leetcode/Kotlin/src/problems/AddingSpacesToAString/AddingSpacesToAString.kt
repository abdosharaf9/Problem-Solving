package problems.AddingSpacesToAString

// https://leetcode.com/problems/adding-spaces-to-a-string/

private class Solution {
    // Time: O(n)
    // Space: O(1)
    fun addSpaces(s: String, spaces: IntArray): String {
        // Add each character to the result and check if we need to add
        // a space before it using a second pointer to the spaces array
        val res = StringBuilder("")
        var j = 0

        for (i in s.indices) {
            if (j < spaces.size && i == spaces[j]) {
                res.append(" ")
                j++
            }
            res.append(s[i])
        }

        return res.toString()
    }

    /*fun addSpaces(s: String, spaces: IntArray) = buildString(s.length + spaces.size) {
        var j = 0
        s.forEachIndexed { i, c ->
            if (spaces.getOrNull(j) == i) {
                append(" ")
                j++
            }
            append(c)
        }
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.addSpaces("LeetcodeHelpsMeLearn", intArrayOf(8, 13, 15)))
    println(sol.addSpaces("icodeinpython", intArrayOf(1, 5, 7, 9)))
    println(sol.addSpaces("spacing", intArrayOf(0, 1, 2, 3, 4, 5, 6)))
}