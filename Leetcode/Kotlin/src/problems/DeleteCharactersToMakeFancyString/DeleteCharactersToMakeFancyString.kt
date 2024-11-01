package problems.DeleteCharactersToMakeFancyString

// https://leetcode.com/problems/delete-characters-to-make-fancy-string/

private class Solution {
    fun makeFancyString(s: String): String {
        val result = StringBuilder()

        var curCount = 1
        for (c in s) {
            if (result.isNotEmpty() && result.last() == c) {
                curCount++
            } else {
                curCount = 1
            }

            if (curCount <= 2) result.append(c)
        }

        return result.toString()
    }
}

fun main() {
    val sol = Solution()
    println(sol.makeFancyString("leeetcode"))
    println(sol.makeFancyString("aaabaaaa"))
    println(sol.makeFancyString("aab"))
}