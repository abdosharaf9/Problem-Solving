package DifferentWaysToAddParentheses

// https://leetcode.com/problems/different-ways-to-add-parentheses/

class Solution {

    /** Solution 1 */
    /*fun diffWaysToCompute(expression: String): List<Int> {
        val operations = mapOf(
            '+' to { x: Int, y: Int -> x + y },
            '-' to { x: Int, y: Int -> x - y },
            '*' to { x: Int, y: Int -> x * y }
        )

        fun backtracking(left: Int, right: Int): List<Int> {
            val result = mutableListOf<Int>()

            for (i in left..right) {
                val cur = expression[i]

                if (operations.containsKey(cur)) {
                    val leftPart = backtracking(left, i - 1)
                    val rightPart = backtracking(i + 1, right)

                    for (x in leftPart) {
                        for (y in rightPart) {
                            result.add(operations[cur]!!.invoke(x, y))
                        }
                    }
                }
            }

            if (result.isEmpty()) {
                expression.substring(left, right + 1).toIntOrNull()?.let { result.add(it) }
            }

            return result
        }

        return backtracking(0, expression.lastIndex)
    }*/

    /** Solution 2 */
    fun diffWaysToCompute(expression: String): List<Int> {
        if (expression.all { it.isDigit() }) {
            return listOf(expression.toInt())
        }

        val results = mutableListOf<Int>()

        for (i in expression.indices) {
            val char = expression[i]

            if (char == '+' || char == '-' || char == '*') {
                val leftPart = diffWaysToCompute(expression.substring(0, i))
                val rightPart = diffWaysToCompute(expression.substring(i + 1))

                for (left in leftPart) {
                    for (right in rightPart) {
                        when (char) {
                            '+' -> results.add(left + right)
                            '-' -> results.add(left - right)
                            '*' -> results.add(left * right)
                        }
                    }
                }
            }
        }

        return results
    }
}

fun main() {
    val sol = Solution()
    print(sol.diffWaysToCompute("2-1-1"))
    print(sol.diffWaysToCompute("2*3-4*5"))
}

fun print(arr: List<Int>) {
    for (x in arr) {
        print("$x, ")
    }
    println()
}