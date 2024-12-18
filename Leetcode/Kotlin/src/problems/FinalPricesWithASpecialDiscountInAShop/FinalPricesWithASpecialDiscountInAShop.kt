package problems.FinalPricesWithASpecialDiscountInAShop

import utils.printArray
import java.util.Stack

// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/

private class Solution {
    // Time: O(n)
    // Space: O(n)
    fun finalPrices(prices: IntArray): IntArray {
        val n = prices.size
        val ans = IntArray(n) { prices[it] }

        // Used as Monotonic stack to keep the items in an increasing order
        val stack = Stack<Int>()

        for (i in 0..<n) {
            // If the current item is smaller than the previous ones, use it
            // as the discount for them and pop them from the stack.
            while (stack.isNotEmpty() && prices[stack.peek()] >= prices[i]) {
                val j = stack.pop()
                ans[j] -= prices[i]
            }

            // Add the current item to the stack.
            stack.push(i)
        }

        return ans
    }

    // Time: O(n^2)
    // Space: O(n)
    /*fun finalPrices(prices: IntArray): IntArray {
        val n = prices.size

        for (i in 0..<n) {
            var discount = 0

            // Finding the next element smaller than or equal to be the discount.
            for (j in i + 1..<n) {
                if (prices[j] <= prices[i]) {
                    discount = prices[j]
                    break
                }
            }

            // Applying the found discount.
            prices[i] = prices[i] - discount
        }

        return prices
    }*/
}

fun main() {
    val sol = Solution()
    printArray(sol.finalPrices(intArrayOf(8, 4, 6, 2, 3)))
    printArray(sol.finalPrices(intArrayOf(1, 2, 3, 4, 5)))
    printArray(sol.finalPrices(intArrayOf(10, 1, 1, 6)))
}