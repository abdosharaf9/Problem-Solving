package problems.StringToInteger

// https://leetcode.com/problems/string-to-integer-atoi/

private class Solution {
    fun myAtoi(s: String): Int {
        var str = s.trim()

        if (str.isEmpty()) return 0

        var result: Long = 0
        var isNegative = false
        var isLeadingZeros = true

        when {
            str[0] == '-' -> {
                isNegative = true
                str = str.drop(1)
            }

            str[0] == '+' -> {
                str = str.drop(1)
            }

            !str[0].isDigit() -> {
                return 0
            }
        }

        var i = 0
        while (i < str.length) {
            if (str[i] == '0' && isLeadingZeros) i++
            else if (!str[i].isDigit()) {
                return if (isNegative) -result.toInt() else result.toInt()
            } else {
                isLeadingZeros = false
                result = (result * 10) + str[i].digitToInt()
                if (!isNegative && result > Int.MAX_VALUE.toLong()) result = Int.MAX_VALUE.toLong()
                else if (isNegative && result > -Int.MIN_VALUE.toLong()) result = -Int.MIN_VALUE.toLong()
                i++
            }
        }

        return if (isNegative) -result.toInt() else result.toInt()
    }
}

fun main() {
    val sol = Solution()
    println(sol.myAtoi("42"))
    println(sol.myAtoi("-042"))
    println(sol.myAtoi("1337c0d3"))
    println(sol.myAtoi("0-1"))
    println(sol.myAtoi("words and 987"))
    println(sol.myAtoi(""))
    println(sol.myAtoi("-91283472332"))
}