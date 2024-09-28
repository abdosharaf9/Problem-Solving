package FindMinimumOperationsToMakeAllElementsDivisibleByThree

// https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/

class Solution {
    fun minimumOperations(nums: IntArray): Int {
        var res = 0
        nums.forEach {
            if(it % 3 != 0) res++
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.minimumOperations(intArrayOf(1, 2, 3, 4)))
}