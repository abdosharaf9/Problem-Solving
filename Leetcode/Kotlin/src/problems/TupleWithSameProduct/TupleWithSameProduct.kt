package problems.TupleWithSameProduct

// https://leetcode.com/problems/tuple-with-same-product/

private class Solution {
    // Using one hashmaps.
    // Time: O(n^2)
    // Space: O(n)
    fun tupleSameProduct(nums: IntArray): Int {
        // Store the number of times each product can be computed.
        val productCount = mutableMapOf<Int, Int>()

        // Loop over all the pairs (a, b) and count each product.
        for (i in 0..nums.lastIndex) {
            for (j in i + 1..nums.lastIndex) {
                // Compute the product.
                val product = nums[i] * nums[j]

                // Update the product count by 1.
                productCount[product] = (productCount[product] ?: 0) + 1
            }
        }

        var res = 0
        for (x in productCount.values) {
            // If we have 2 pairs, then we can just have 1 tuple. When we add a new pair,
            // then we can form 3 tuples, which is the number of old tuples + old pairs count.
            // 1 -> 0 => 0 + 0
            // 2 -> 1 => 0 + 1
            // 3 -> 3 => 1 + 2
            // 4 -> 6 => 3 + 3
            // and so on...
            val tuples = (x * (x - 1)) / 2

            // Each tuple can be 8 unique tuples like:
            // (a,b,c,d), (a,b,d,c), (b,a,c,d), (b,a,d,c)
            // (c,d,a,b), (c,d,b,a), (d,c,a,b), (d,c,b,a)
            res += tuples * 8
        }

        return res
    }

    // Using two hashmaps.
    // Time: O(n^2)
    // Space: O(n)
    /*fun tupleSameProduct(nums: IntArray): Int {
        // Store the number of times each product can be computed.
        val productCount = mutableMapOf<Int, Int>()

        // Store the count of tuples (a, b, c, d) we can perform for each product.
        val tuplesCount = mutableMapOf<Int, Int>()

        // Loop over all the pairs (a, b) and count each product.
        for (i in 0..nums.lastIndex) {
            for (j in i + 1..nums.lastIndex) {
                // Compute the product.
                val product = nums[i] * nums[j]

                // If we have 2 pairs, then we can just have 1 tuple. When we add a new pair,
                // then we can form 3 tuples, which is the number of old tuples + old pairs count.
                // 1 -> 0 => 0 + 0
                // 2 -> 1 => 0 + 1
                // 3 -> 3 => 1 + 2
                // 4 -> 6 => 3 + 3
                // and so on...
                tuplesCount[product] = (tuplesCount[product] ?: 0) + (productCount[product] ?: 0)

                // Update the product count by 1.
                productCount[product] = (productCount[product] ?: 0) + 1
            }
        }

        var res = 0
        for (x in tuplesCount.values) {
            // Each tuple can be 8 unique tuples like:
            // (a,b,c,d), (a,b,d,c), (b,a,c,d), (b,a,d,c)
            // (c,d,a,b), (c,d,b,a), (d,c,a,b), (d,c,b,a)
            res += x * 8
        }

        return res
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.tupleSameProduct(intArrayOf(2, 3, 4, 6)))
    println(sol.tupleSameProduct(intArrayOf(1, 2, 4, 5, 10)))
}