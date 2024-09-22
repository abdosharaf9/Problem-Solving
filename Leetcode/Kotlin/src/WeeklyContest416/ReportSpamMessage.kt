package WeeklyContest416

// https://leetcode.com/problems/report-spam-message/

class Solution {
    fun reportSpam(message: Array<String>, bannedWords: Array<String>): Boolean {
        var count = 0
        val bannedWordsSet = bannedWords.toSet()

        for (word in message) {
            if (word in bannedWordsSet) count++
            if (count == 2) return true
        }

        return false
    }
}

fun main() {
    val sol = Solution()
    println(sol.reportSpam(arrayOf("hello", "world", "leetcode"), arrayOf("world", "hello")))
    println(sol.reportSpam(arrayOf("hello", "programming", "fun"), arrayOf("world", "programming", "leetcode")))
}