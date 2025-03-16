package problems.MinimumTimeToRepairCars

// https://leetcode.com/problems/minimum-time-to-repair-cars/

private class Solution {
    fun repairCars(ranks: IntArray, cars: Int): Long {
        fun isValidTime(time: Long): Boolean {
            var count = 0
            for (r in ranks) {
                count += sqrt((time / r).toDouble()).toInt()

                if (count >= cars) {
                    return true
                }
            }

            return count >= cars
        }

        var left = 1L
        var right = ranks[0] * cars * cars.toLong()
        var res = 0L

        while (left <= right) {
            val mid = (left + right) / 2

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