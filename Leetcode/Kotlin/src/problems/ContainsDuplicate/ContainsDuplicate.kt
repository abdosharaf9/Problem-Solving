package problems.ContainsDuplicate

// https://leetcode.com/problems/contains-duplicate/

private class Solution {

    fun containsDuplicate(nums: IntArray): Boolean {
        return nums.toSet().size != nums.size
    }

    /*fun containsDuplicate(nums: IntArray): Boolean {
        val mp = mutableMapOf<Int, Int>()
        nums.forEach {
            if (mp.containsKey(it)) return true
            else mp[it] = 0
        }
        return false
    }*/

    /*fun containsDuplicate(nums: IntArray): Boolean {
        val freq = nums.groupBy { it }.mapValues { it.value.size }
        return freq.values.any { it >= 2 }
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.containsDuplicate(intArrayOf(1, 2, 3, 1)))
    println(sol.containsDuplicate(intArrayOf(1, 2, 3, 4)))
    println(sol.containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
}