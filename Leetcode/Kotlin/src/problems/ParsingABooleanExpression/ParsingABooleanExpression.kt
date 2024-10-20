package problems.ParsingABooleanExpression

import java.util.Stack

// https://leetcode.com/problems/parsing-a-boolean-expression/

private class Solution {
    val stack = Stack<Char>()

    fun parseBoolExpr(expression: String): Boolean {
        for (c in expression) {
            when (c) {
                // Don't care about it
                ',' -> continue

                // Evaluate and push the result to the stack
                ')' -> stack.push(evaluate())

                // Push the value to the stack whatever it is
                else -> stack.push(c)
            }
        }

        // Return the peek of the stack
        return stack.peek() == 't'
    }

    fun evaluate(): Char {
        // Get the values to evaluate the expression
        val values = mutableListOf<Boolean>()
        while (stack.peek() != '(') {
            values.add(stack.pop() == 't')
        }

        stack.pop() // Remove the '('
        val op = stack.pop() // The operation: '!' or '|' or '&'

        val result = when (op) {
            // Not only takes a single input
            '!' -> !values[0]

            // True won't change the result of the AND operation whatever the input is
            '&' -> values.fold(true) { result, x -> result and x }

            // False won't change the result of the OR operation whatever the input is
            '|' -> values.fold(false) { result, x -> result or x }

            // Won't happen anyway
            else -> false
        }

        return if (result) 't' else 'f'
    }
}

fun main() {
    val sol = Solution()
    println(sol.parseBoolExpr("&(|(f))"))
    println(sol.parseBoolExpr("|(f,f,f,t)"))
    println(sol.parseBoolExpr("!(&(f,t))"))
}