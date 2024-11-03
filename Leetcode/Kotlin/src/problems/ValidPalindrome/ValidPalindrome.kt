package problems.ValidPalindrome

// https://leetcode.com/problems/valid-palindrome/

private class Solution {
    fun isPalindrome(s: String): Boolean {
        val str = s.lowercase()
        var left = 0
        var right = s.lastIndex

        while (left < right) {
            if (!str[left].isLetterOrDigit()) left++
            else if (!str[right].isLetterOrDigit()) right--
            else {
                if (str[left] != str[right]) return false

                left++
                right--
            }
        }

        return true
    }

    /*fun isPalindrome(s: String): Boolean {
        val temp = s.filter { it.isLetterOrDigit() }.lowercase()
        return temp == temp.reversed()
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.isPalindrome("A man, a plan, a canal: Panama"))
    println(sol.isPalindrome("race a car"))
    println(sol.isPalindrome(""))
}