package problems.StringCompressionIII

// https://leetcode.com/problems/string-compression-iii/

private class Solution {
    fun compressedString(word: String): String {
        val result = StringBuilder()
        var i = 0

        while (i < word.length) {
            val c = word[i]
            var count = 1

            while (i != word.lastIndex && count != 9 && word[i + 1] == c) {
                count++
                i++
            }

            result.append("$count$c")
            i++
        }


        return result.toString()
    }
}

fun main() {
    val sol = Solution()
    println(sol.compressedString("abcde"))
    println(sol.compressedString("aaaaaaaaaaaaaabb"))
}