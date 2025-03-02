package problems.NumberOfEmployeesWhoMetTheTarget

// https://leetcode.com/problems/number-of-employees-who-met-the-target/

private class Solution {
    // Time: O(n)
    // Space: O(1)
    fun numberOfEmployeesWhoMetTarget(hours: IntArray, target: Int): Int {
        return hours.count { it >= target }
    }

    // Time: O(n)
    // Space: O(1)
    /*fun numberOfEmployeesWhoMetTarget(hours: IntArray, target: Int): Int {
        var res = 0
        for (h in hours) {
            if (h >= target) res++
        }

        return res
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.numberOfEmployeesWhoMetTarget(intArrayOf(0, 1, 2, 3, 4), 2))
    println(sol.numberOfEmployeesWhoMetTarget(intArrayOf(5, 1, 4, 2, 2), 6))
}