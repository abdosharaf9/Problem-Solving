package problems.FindMinimumInRotatedSortedArray

//

private class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        var mid: Int

        while (left < right) {
            mid = (left + right) / 2

            if (nums[mid] > nums[right]) left = mid + 1
            else right = mid
        }

        return nums[left]
    }
}

fun main() {
    val sol = Solution()
    println(sol.findMin(intArrayOf(3, 4, 5, 1, 2)))
    println(sol.findMin(intArrayOf(4, 5, 6, 7, 0, 1, 2)))
    println(sol.findMin(intArrayOf(11, 13, 15, 17)))
}