// Problem Link: https://leetcode.com/problems/palindrome-number

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