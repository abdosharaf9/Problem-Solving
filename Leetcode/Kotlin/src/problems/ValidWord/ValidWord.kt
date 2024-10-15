package problems.ValidWord

// https://leetcode.com/problems/valid-word/

private class Solution {

    fun Char.isVowel() = when (this.lowercaseChar()) {
        'a', 'e', 'i', 'o', 'u' -> true
        else -> false
    }

    fun isValid(word: String): Boolean {
        if (word.length < 3) return false

        var seenVowel = false
        var seenConst = false

        for (c in word) {
            if (c.isVowel()) seenVowel = true
            else if (c.isLetter()) seenConst = true
            else if (!c.isDigit()) return false
        }

        return seenVowel && seenConst
    }


    /*fun isValid(word: String): Boolean {
        if (word.length < 3) return false

        val vowels = "AaEeIiOoUu"
        val constants = "BbCcDdFfGgHhJjKkLlMmNnPpQqRrSsTtVvWwXxYyZz"
        val numbers = "0123456789"
        val allowed = vowels + constants + numbers

        var seenVowel = false
        var seenConst = false

        for (c in word) {
            if (c in vowels) seenVowel = true
            if (c in constants) seenConst = true
            if (c !in allowed) return false
        }

        return seenVowel && seenConst
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.isValid("234Adas"))
    println(sol.isValid("b3"))
    println(sol.isValid("a3\$e"))
}