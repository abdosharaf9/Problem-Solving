package problems.FinalValueOfVariableAfterPerformingOperations

// https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

private class Solution {
    fun finalValueAfterOperations(operations: Array<String>): Int {
        var x = 0
        operations.forEach {
            when (it) {
                "++X", "X++" -> x++
                "--X", "X--" -> x--
            }
        }

        return x
    }
}

fun main() {
    val sol = Solution()
    println(sol.finalValueAfterOperations(arrayOf("--X", "X++", "X++")))
}