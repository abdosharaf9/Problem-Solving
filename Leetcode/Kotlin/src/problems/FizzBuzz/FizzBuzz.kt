package problems.FizzBuzz

import utils.printArray

// https://leetcode.com/problems/fizz-buzz/

private class Solution {
    fun fizzBuzz(n: Int): List<String> {
        val res = mutableListOf<String>()

        for(i in 1..n) {
            res.add(
                when {
                    i % 3 == 0 && i % 5 == 0 -> "FizzBuzz"
                    i % 3 == 0 -> "Fizz"
                    i % 5 == 0 -> "Buzz"
                    else -> "$i"
                }
            )
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    printArray(sol.fizzBuzz(3))
    printArray(sol.fizzBuzz(5))
    printArray(sol.fizzBuzz(15))
}