package problems.ConstructSmallestNumberFromDIString

import java.util.Stack

// https://leetcode.com/problems/construct-smallest-number-from-di-string/

private class Solution {
    // Time: O(n)
    // Space: O(n)
    fun smallestNumber(pattern: String): String {
        // Store the result string.
        val res = StringBuilder()

        // Used to store temporary the numbers we will use.
        val stack = Stack<Int>()

        // Loop n + 1 times.
        for (i in 0..pattern.length) {
            // Add the current number to the stack, and note that we start at 1.
            stack.add(i + 1)

            // If we found an 'I' in the pattern which means the numbers must start to increase,
            // directly pop all the numbers in the stack and add them to the stack. Also, we
            // pop all the numbers if we reach the last iteration. This way we will add the
            // numbers to the stack when we find a 'D', because this will allow us to pop the
            // numbers in descending order (decreasing).
            while (stack.isNotEmpty() && (i == pattern.length || pattern[i] == 'I')) {
                res.append(stack.pop().toString())
            }
        }

        return res.toString()

        // DDDI
        // i = 0 -> stack: [1], res: ""
        // i = 1 -> stack: [1,2], res: ""
        // i = 2 -> stack: [1,2,3], res: ""
        // i = 3 -> stack: [], res: "4321" (added 4 before popping all the numbers)
        // i = 4 -> stack: [], res: "43215" (added 5 before popping all the numbers)

        // IIID
        // i = 0 -> stack: [], res: "1" (added 1 before popping all the numbers)
        // i = 1 -> stack: [], res: "12" (added 2 before popping all the numbers)
        // i = 2 -> stack: [], res: "123" (added 3 before popping all the numbers)
        // i = 3 -> stack: [4], res: "123"
        // i = 4 -> stack: [], res: "12354" (added 5 before popping all the numbers)
    }
}

fun main() {
    val sol = Solution()
    println(sol.smallestNumber("IIIDIDDD"))
    println(sol.smallestNumber("DDD"))
}