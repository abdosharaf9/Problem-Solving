package problems.NeighboringBitwiseXOR

// https://leetcode.com/problems/neighboring-bitwise-xor/

private class Solution {
    // Time: O(n)
    // Space: O(1)
    fun doesValidArrayExist(derived: IntArray): Boolean {
        // Because we use each item of the original array twice to create
        // the derived array, thus if we XORed all the derived numbers, we
        // must get 0, because each item cancel itself.
        return derived.fold(0) { acc, i -> acc xor i } == 0
    }
}

fun main() {
    val sol = Solution()
    println(sol.doesValidArrayExist(intArrayOf(1, 1, 0)))
    println(sol.doesValidArrayExist(intArrayOf(1, 1)))
    println(sol.doesValidArrayExist(intArrayOf(1, 0)))
}