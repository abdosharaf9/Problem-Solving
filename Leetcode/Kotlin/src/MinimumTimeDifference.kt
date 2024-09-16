import kotlin.math.min

// https://leetcode.com/problems/minimum-time-difference/

class Solution {
    fun findMinDifference(timePoints: List<String>): Int {
        val times = timePoints.map { toMinutes(it) }.sorted().toMutableList()
        times.add(times[0] + 1440)

        var result = Int.MAX_VALUE
        for (i in 1..times.lastIndex) {
            result = min(result, times[i] - times[i - 1])
        }

        return result
    }

    private fun toMinutes(time: String): Int {
        val (hours, minutes) = time.split(":").map { it.toInt() }
        return hours * 60 + minutes
    }
}

fun main() {
    val solution = Solution()
    println(solution.findMinDifference(listOf("23:59", "00:00")))
    println(solution.findMinDifference(listOf("00:00", "23:59", "00:00")))
}