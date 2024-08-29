// https://leetcode.com/problems/remove-element/

fun removeElement(nums: IntArray, `val`: Int): Int {
    var i = 0

    for (idx in 0..nums.lastIndex) {
        if (nums[idx] != `val`) {
            nums[i] = nums[idx]
            i++
        }
    }

    return i
}

fun main() {
    println(removeElement(nums = intArrayOf(3, 2, 2, 3), `val` = 3))
    println(removeElement(nums = intArrayOf(0,1,2,2,3,0,4,2), `val` = 2))
}