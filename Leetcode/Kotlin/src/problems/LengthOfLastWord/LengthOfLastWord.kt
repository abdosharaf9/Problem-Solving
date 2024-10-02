package problems.LengthOfLastWord

// https://leetcode.com/problems/length-of-last-word/

private class Solution {
    fun lengthOfLastWord(s: String): Int {
        val temp = s.split(' ').filter { it.isNotEmpty() }
        return temp.last().length
    }
}

fun main() {
    val sol = Solution()
    println(sol.lengthOfLastWord("Hello World"))
    println(sol.lengthOfLastWord("   fly me   to   the moon  "))
    println(sol.lengthOfLastWord("luffy is still joyboy"))
}