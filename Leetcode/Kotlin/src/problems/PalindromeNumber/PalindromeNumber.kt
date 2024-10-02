package problems.PalindromeNumber

// https://leetcode.com/problems/palindrome-number

private class Solution {
    fun isPalindrome(x: Int): Boolean {
        return if (x < 0) {
            false
        } else {
            var temp = x
            var reversed = 0

            while (temp > 0) {
                val digit = temp % 10
                reversed = (reversed * 10) + digit
                temp /= 10
            }

            reversed == x
        }
    }
}

fun main() {
    val sol = Solution()
    println(sol.isPalindrome(121))
    println(sol.isPalindrome(-121))
    println(sol.isPalindrome(10))
}