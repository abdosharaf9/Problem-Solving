package problems.ReverseInteger

// https://leetcode.com/problems/reverse-integer/

private class Solution {
    fun reverse(x: Int): Int {
        var num = x
        var reversed = 0

        while (num != 0) {
            val digit = num % 10
            num /= 10

            if (reversed > Int.MAX_VALUE / 10 || (reversed == Int.MAX_VALUE / 10 && digit > 7)) {
                return 0
            }

            if (reversed < Int.MIN_VALUE / 10 || (reversed == Int.MIN_VALUE / 10 && digit < -8)) {
                return 0
            }

            reversed = reversed * 10 + digit
        }

        return reversed
    }
}

fun main() {
    val sol = Solution()
    println(sol.reverse(123))
    println(sol.reverse(-123))
    println(sol.reverse(120))
    println("${Int.MAX_VALUE} => ${sol.reverse(Int.MAX_VALUE)}")
    println("${Int.MIN_VALUE} => ${sol.reverse(Int.MIN_VALUE)}")
}