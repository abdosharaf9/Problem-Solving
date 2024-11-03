package problems.RotateString

// https://leetcode.com/problems/rotate-string/

private class Solution {
    fun rotateString(s: String, goal: String): Boolean {
        return s.length == goal.length && (s + s).contains(goal)
    }

    /*fun rotateString(s: String, goal: String): Boolean {
        if (s.length != goal.length) return false

        for (i in 0..s.lastIndex) {
            if (goal == s.substring(i) + s.substring(0, i)) return true
        }

        return false
    }*/

    /*fun rotateString(s: String, goal: String): Boolean {
        if (s.length != goal.length) return false
        if (s == goal) return true

        var temp = s
        repeat(goal.length) {
            temp = temp.last() + temp.dropLast(1)
            if (temp == goal) return true
        }

        return false
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.rotateString("abcde", "cdeab"))
    println(sol.rotateString("abcde", "abced"))
}