// Problem Link: https://leetcode.com/problems/two-sum/

fun twoSum(nums: IntArray, target: Int): IntArray {
    for (i in 0..<nums.size) {
        for (j in i + 1..<nums.size) {
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf()
}