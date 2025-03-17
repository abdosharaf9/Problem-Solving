package problems.MinimumTimeToRepairCars

import kotlin.math.sqrt

// https://leetcode.com/problems/minimum-time-to-repair-cars/

private class Solution {
    // Time: O(n * log (r * c^2)), where r is any rank value from the ranks' array, and c is the number of cars.
    // Space: O(1)
    fun repairCars(ranks: IntArray, cars: Int): Long {
        // Check if the chosen time can be used to repair all the cars.
        fun isValidTime(time: Long): Boolean {
            // Store the count of repaired cars.
            var count = 0

            // Count the cars each mechanic can repair in that time.
            for (r in ranks) {
                // Since time = rank * cars^2, thus cars = sqrt(time/rank).
                count += sqrt((time / r).toDouble()).toInt()

                // If the repaired cars count already exceeded the cars' count, break the loop early.
                if (count >= cars) {
                    return true
                }
            }

            // Is the repaired cars count in the chosen time bigger than or equal to the cars' count?
            return count >= cars
        }

        // Initialize the search range and the result. The largest time value would be the time any
        // mechanic needs to repair all the cars, thus we used the first one, because it doesn't matter.
        var left = 1L
        var right = ranks[0] * cars * cars.toLong()
        var res = 0L

        while (left <= right) {
            // Calculate the mid value.
            val mid = (left + right) / 2

            // If the mid value is valid, update the result and try to choose a smaller value.
            // IF not, choose a bigger one.
            if (isValidTime(mid)) {
                res = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    sol.repairCars(intArrayOf(4, 2, 3, 1), 10)
    sol.repairCars(intArrayOf(5, 1, 8), 6)
}