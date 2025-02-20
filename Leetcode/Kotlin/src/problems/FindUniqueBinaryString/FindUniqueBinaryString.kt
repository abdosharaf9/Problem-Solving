package problems.FindUniqueBinaryString

import kotlin.math.pow

// https://leetcode.com/problems/find-unique-binary-string/

private class Solution {
    // Proof of contradiction.
    // Time: O(n)
    // Space: O(1)
    fun findDifferentBinaryString(nums: Array<String>): String {
        // Initialize the result with an empty string.
        val res = StringBuilder()

        // Loop over all the numbers and append the inverse of the ith character in the ith number.
        // We are sure that the result won't be in the given numbers, because it differs from
        // each number in at least one character.
        for (i in nums.indices) {
            res.append(
                if (nums[i][i] == '0') '1'
                else '0'
            )
        }

        return res.toString()
    }

    // Backtracking and build the result character by character.
    // Time: O(2^n)
    // Space: O(n)
    /*fun findDifferentBinaryString(nums: Array<String>): String {
        // Store all the numbers in a set to access them in O(1).
        val n = nums.size
        val numsSet = HashSet<String>()
        nums.forEach { numsSet.add(it) }

        // Initialize the result with an empty string.
        val res = StringBuilder()

        fun backtrack(i: Int): Boolean {
            // If we reached the last index, check if the current result is not in the given numbers.
            if (i == n) {
                return res.toString() !in numsSet
            }

            // Try to use the '0' in the current index.
            res.append('0')
            var cur = backtrack(i + 1)
            if (cur) return true
            res.deleteAt(i)

            // Try to use the '1' in the current index.
            res.append('1')
            cur = backtrack(i + 1)
            if (cur) return true
            res.deleteAt(i)

            // We can't form a valid result.
            return false
        }

        backtrack(0)
        return res.toString()
    }*/

    // Backtracking using a predefined result with all characters are 0.
    // Time: O(n * 2^n), where the O(n) part comes from joining the character array.
    // Space: O(n)
    /*fun findDifferentBinaryString(nums: Array<String>): String {
        // Store all the numbers in a set to access them in O(1).
        val n = nums.size
        val numsSet = HashSet<String>()
        nums.forEach { numsSet.add(it) }

        // Initialize the result with zeros and change the characters to get the result.
        val res = CharArray(n) { '0' }

        fun backtrack(i: Int): String? {
            // If we reached the last index, check if the current result is not in the given numbers.
            if (i == n) {
                val cur = res.joinToString("") // O(n)
                return if (cur in numsSet) null else cur
            }

            // Try to use the '0' in the current index.
            var cur = backtrack(i + 1)
            if (cur != null) return cur

            // Try to use the '1' in the current index.
            res[i] = '1'
            cur = backtrack(i + 1)
            if (cur != null) return cur

            // We can't form a valid result.
            return null
        }

        return backtrack(0)!!
    }*/

    // Trying all the numbers in the range.
    // Time: O(2^n * log d), where O(log d) comes from the `getBinaryBaseNum()` function.
    // Space: O(n)
    /*fun findDifferentBinaryString(nums: Array<String>): String {
        // Convert the number into binary.
        fun getBinaryBaseNum(num: Int, size: Int): String { // O(log d)
            var n = num
            val res = StringBuilder()

            while (n > 0) {
                res.insert(0, (n % 2).toString())
                n /= 2
            }

            // Make sure all the number representations are the same length.
            if (res.length < size) {
                res.insert(0, "0".repeat(size - res.length))
            }

            return res.toString()
        }

        // Get the maximum number which is 2^n-1.
        val n = nums.size
        val max = (2.0.pow(n)).toInt() - 1

        // Store all the numbers in a set to access them in O(1).
        val numsSet = HashSet<String>()
        nums.forEach { numsSet.add(it) }

        // Loop over all the possible numbers.
        for (num in 0..max) { // O(2^n)
            // Get the binary representation of the current number and check if it
            // is in the given numbers or not.
            val cur = getBinaryBaseNum(num, n)
            if (!numsSet.contains(cur)) {
                return cur
            }
        }

        // We won't get here anyway.
        return ""
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.findDifferentBinaryString(arrayOf("01", "10")))
    println(sol.findDifferentBinaryString(arrayOf("00", "01")))
    println(sol.findDifferentBinaryString(arrayOf("111", "011", "001")))
}