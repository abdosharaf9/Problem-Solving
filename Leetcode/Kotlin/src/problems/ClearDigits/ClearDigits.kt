package problems.ClearDigits

import java.util.Stack

// https://leetcode.com/problems/clear-digits/

private class Solution {
    // Using Array
    // Time: O(n)
    // Space: O(n)
    fun clearDigits(s: String): String {
        // Store the letters.
        val arr = CharArray(s.length) { ' ' }
        var idx = 0

        for (c in s) {
            // If the current character is digit, decrease the pointer and
            // if not, add the letter to the array and increase the pointer.
            if (c.isDigit()) {
                idx--
            } else {
                arr[idx++] = c
            }
        }

        // Form the result string using the letters in the array.
        val res = StringBuilder("")
        for (i in 0..<idx) {
            res.append(arr[i])
        }

        return res.toString()
    }

    // Using the StringBuilder directly
    // Time: O(n)
    // Space: O(1), because we don't use any space other than the result.
    /*fun clearDigits(s: String): String {
        val res = StringBuilder("")
        for (c in s) {
            if (c.isDigit()) {
                res.deleteAt(res.lastIndex)
            } else {
                res.append(c)
            }
        }

        return res.toString()
    }*/

    // Using Stack
    // Time: O(n)
    // Space: O(n)
    /*fun clearDigits(s: String): String {
        // Store the letters.
        val stack = Stack<Char>()

        for (c in s) {
            // If the current character is digit, remove the letter before it
            // and if not, add the letter to the stack.
            if (c.isDigit()) {
                stack.pop()
            } else {
                stack.add(c)
            }
        }

        // Add the letter in the stack to the result string in the correct order.
        val res = StringBuilder("")
        while (stack.isNotEmpty()) {
            res.insert(0, stack.pop())
        }

        return res.toString()
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.clearDigits("abc"))
    println(sol.clearDigits("cb34"))
}