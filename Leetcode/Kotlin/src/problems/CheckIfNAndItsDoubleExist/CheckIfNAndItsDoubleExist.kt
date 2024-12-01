package problems.CheckIfNAndItsDoubleExist

// https://leetcode.com/problems/check-if-n-and-its-double-exist/

private class Solution {
    fun checkIfExist(arr: IntArray): Boolean {
        val exist = mutableMapOf<Int, Boolean>()

        for (n in arr) {
            if (exist.contains(n * 2)) return true
            if (n % 2 == 0 && exist.contains(n / 2)) return true
            exist[n] = true
        }

        return false
    }
}

fun main() {
    val sol = Solution()
    println(sol.checkIfExist(intArrayOf(10, 2, 5, 3)))
    println(sol.checkIfExist(intArrayOf(3, 1, 7, 11)))
}