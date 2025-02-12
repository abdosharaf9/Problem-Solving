package problems.MaxSumOfAPairWithEqualSumOfDigits

import java.util.PriorityQueue

// https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/

class Solution {
    // Time: O(n * log m), where the O(log m) part comes from the `getDigitsSum()` function.
    // Time: O(1), because we use an array with fixed size.
    fun maximumSum(nums: IntArray): Int {
        fun getDigitsSum(num: Int): Int { // O(log m), because each iteration the num is divided by 10
            var sum = 0
            var n = num
            while (n > 0) {
                sum += n % 10
                n /= 10
            }
            return sum
        }

        // The maximum number will be 10^9, thus the number with the maximum sum is 999999999
        // that has a sum of 81, so we use an array with 82 slots.
        // In this array, we save only the maximum number with each summation, not the whole list.
        val sums = IntArray(82)

        // Initial maximum sum.
        var max = -1

        for (num in nums) { // O(n * log m), because each iteration we use the `getDigitsSum()` function
            // Get the digits' sum of the current number.
            val sum = getDigitsSum(num)

            // If there was a number with this summation before, try to maximize the result.
            if (sums[sum] > 0) {
                max = maxOf(max, sums[sum] + num)
            }

            // Update the maximum number with the current summation.
            sums[sum] = maxOf(sums[sum], num)
        }

        return max
    }

    // Time: O(n * log m), where the O(log m) part comes from the Priority Queue.
    // Time: O(n), because each summation will have a Priority Queue.
    /*fun maximumSum(nums: IntArray): Int {
        fun getDigitsSum(num: Int): Int { // O(log m), because each iteration the num is divided by 10
            var sum = 0
            var n = num
            while (n > 0) {
                sum += n % 10
                n /= 10
            }
            return sum
        }

        // Each summation will have a Max Heap to store the list of numbers sorted in descending order.
        val sums = mutableMapOf<Int, PriorityQueue<Int>>()

        for (num in nums) { // O(n * log m), because each iteration we add to a Max Heap.
            // Get the digits' sum of the current number.
            val sum = getDigitsSum(num)

            // Add the number to the current summation's heap.
            sums.computeIfAbsent(sum) { PriorityQueue(compareByDescending<Int> { it }) }.add(num)
        }

        // Initial maximum sum.
        var max = -1

        for (queue in sums.values) {
            // If the heap doesn't have 2 numbers at least, continue to the next one.
            if (queue.size < 2) continue

            // Sum the maximum two numbers.
            var curMax = queue.poll()!!
            curMax += queue.poll()!!

            // Try to maximize the result.
            max = maxOf(max, curMax)
        }

        return max
    }*/

    // Time: O(n * log n), where the O(log n) part comes from sorting the lists.
    // Time: O(n), because each summation will have a list.
    /*fun maximumSum(nums: IntArray): Int {
        fun getDigitsSum(num: Int): Int { // O(log m), because each iteration the num is divided by 10
            var sum = 0
            var n = num
            while (n > 0) {
                sum += n % 10
                n /= 10
            }
            return sum
        }

        // Each summation will have a list of numbers.
        val sums = mutableMapOf<Int, MutableList<Int>>()

        for (num in nums) { // O(n * log m), because each iteration we use the `getDigitsSum()` function
            // Get the digits' sum of the current number.
            val sum = getDigitsSum(num)

            // Add the number to the current summation's list.
            sums.computeIfAbsent(sum) { mutableListOf() }.add(num)
        }

        // Initial maximum sum.
        var max = -1

        for (list in sums.values) {
            // If the list doesn't have 2 numbers at least, continue to the next one.
            if (list.size < 2) continue

            // Sort the list to get the maximum 2 numbers.
            list.sort()

            // Sum the maximum two numbers.
            val curMax = list.last() + list[list.lastIndex - 1]

            // Try to maximize the result.
            max = maxOf(max, curMax)
        }

        return max
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.maximumSum(intArrayOf(18, 43, 36, 13, 7)))
    println(sol.maximumSum(intArrayOf(10, 12, 19, 14)))
}