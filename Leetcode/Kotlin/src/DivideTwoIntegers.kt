import kotlin.math.abs

// https://leetcode.com/problems/divide-two-integers

fun divide(dividend: Int, divisor: Int): Int {
    var result = 0
    val isNegative = (dividend < 0) xor (divisor < 0)
    var x: Long = abs(dividend.toLong())
    val y: Long = abs(divisor.toLong())

    if (y > x) return 0
    if (x == 1L || y == 1L) {
        return if (dividend == Int.MIN_VALUE && divisor == -1) Int.MAX_VALUE
        else dividend * divisor
    }

    while (x >= y) {
        result++
        x -= y
    }

    return if (isNegative) -result else result
}

fun main() {
    println(divide(10, 3))
    println(divide(7, -3))
    println(divide(-2147483648, -1))
    println(divide(-2147483648, 1))
}