package problems.MinimumTotalDistanceTraveled

import kotlin.math.abs

// https://leetcode.com/problems/minimum-total-distance-traveled/

private class Solution {
    fun minimumTotalDistance(robot: List<Int>, factory: Array<IntArray>): Long {
        val factories = mutableListOf<Int>()
        factory.forEach { f ->
            repeat(f[1]) { factories.add(f[0]) }
        }

        factories.sort()
        val robots = robot.sorted()

        val cache = Array(robots.size) { LongArray(factories.size) { -1L } }

        fun calculateCost(robotIdx: Int, factoryIdx: Int): Long {
            if (robotIdx < 0) return 0
            if (factoryIdx < 0) return Long.MAX_VALUE / 2
            if (cache[robotIdx][factoryIdx] != -1L) return cache[robotIdx][factoryIdx]

            val current = abs(robots[robotIdx] - factories[factoryIdx]) + calculateCost(robotIdx - 1, factoryIdx - 1)
            val next = calculateCost(robotIdx, factoryIdx - 1)
            cache[robotIdx][factoryIdx] = minOf(current, next)

            return cache[robotIdx][factoryIdx]
        }

        return calculateCost(robots.lastIndex, factories.lastIndex)
    }
}

fun main() {
    val sol = Solution()

    println(
        sol.minimumTotalDistance(
            listOf(0, 4, 6),
            arrayOf(intArrayOf(2, 2), intArrayOf(4, 2))
        )
    )

    println(
        sol.minimumTotalDistance(
            listOf(1, -1),
            arrayOf(intArrayOf(-2, 1), intArrayOf(2, 1))
        )
    )
}