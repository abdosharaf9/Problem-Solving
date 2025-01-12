package problems.CheckIfAParenthesesStringCanBeValid

import java.util.Stack

// https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/

private class Solution {
    // In this solution, we aren't trying to get the valid string, we just
    // match all the closing parentheses with opening ones before them.
    // Time: O(n)
    // Space: O(n)
    fun canBeValid(s: String, locked: String): Boolean {
        // If the length is odd, we can't form any valid parentheses.
        if (s.length % 2 != 0) return false

        // Store the locked and unlocked indices of opening
        // parentheses in separate stacks to make it easy.
        val stLocked = Stack<Int>()
        val stUnlocked = Stack<Int>()

        for (i in s.indices) {
            if (locked[i] == '0') {
                // Adding unlocked whatever it is because we can change it anyway.
                stUnlocked.push(i)
            } else if (s[i] == '(') {
                // Adding locked opening parentheses.
                stLocked.push(i)
            } else {
                // We have a locked closing parenthesis, so we need to match it with
                // a previous opening one. We are trying to be greedy and use the locked
                // opening parentheses first, and if there are no other locked, we use the unlocked.
                if (stLocked.isNotEmpty()) {
                    stLocked.pop()
                } else if (stUnlocked.isNotEmpty()) {
                    stUnlocked.pop()
                } else {
                    // If there is no previous opening parenthesis either locked or unlocked,
                    // we can't match the current closing parenthesis
                    return false
                }
            }
        }

        // If there are still locked opening parentheses, we will match them with any unlocked ones.
        while (stLocked.isNotEmpty() && stUnlocked.isNotEmpty() && stLocked.peek() < stUnlocked.peek()) {
            stLocked.pop()
            stUnlocked.pop()
        }

        // We don't care about the remaining unlocked one because they can be matched
        // with each other. So, we only check if there are any locked opening parentheses left.
        return stLocked.isEmpty()
    }
}

fun main() {
    val sol = Solution()
    println(sol.canBeValid("))()))", "010100"))
    println(sol.canBeValid("()()", "0000"))
    println(sol.canBeValid(")", "0"))
}