package problems.LargestNumber

// https://leetcode.com/problems/largest-number/

private class Solution {
    fun largestNumber(nums: IntArray): String {
        val newList = nums
            .map { it.toString() }
            .sortedWith(CompareNumbers)

        if (newList[0] == "0") return "0"

        return newList.joinToString("")
    }

    class CompareNumbers {
        companion object : Comparator<String> {
            override fun compare(a: String, b: String): Int = when {
                a + b > b + a -> -1
                b + a > a + b -> 1
                else -> 0
            }
        }
    }
}

fun main() {
    val sol = Solution()
    println(sol.largestNumber(intArrayOf(10, 2)))
    println(sol.largestNumber(intArrayOf(3, 30, 34, 5, 9)))
    println(sol.largestNumber(intArrayOf(0, 0, 0, 0)))
}