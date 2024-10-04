package problems.DividePlayersIntoTeamsOfEqualSkill

import java.util.*

// https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/

private class Solution {
    fun dividePlayers(skill: IntArray): Long {
        Arrays.sort(skill)
        val teamSkill = skill.first() + skill.last()

        var left = 0
        var right = skill.lastIndex
        var result = 0L

        while (left < right) {
            if (skill[left] + skill[right] != teamSkill) return -1

            result += skill[left] * skill[right]
            left++
            right--
        }

        return result
    }

    /*fun dividePlayers(skill: IntArray): Long {
        val total = skill.sumOf { it.toLong() }
        val noOfTeams = skill.size / 2

        if (total % noOfTeams != 0L) return -1

        val counts = skill.groupBy { it }.mapValues { it.value.size }.toMutableMap()
        val teamSkill = (total / noOfTeams).toInt()
        var result = 0L

        for (x in skill) {
            if (counts[x] == 0) continue

            val diff = teamSkill - x
            if (counts.getOrDefault(diff, 0) == 0) return -1

            result += x * diff
            counts[x] = counts[x]!! - 1
            counts[diff] = counts[diff]!! - 1
        }

        return result
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.dividePlayers(intArrayOf(3, 2, 5, 1, 3, 4)))
    println(sol.dividePlayers(intArrayOf(3, 4)))
    println(sol.dividePlayers(intArrayOf(1, 1, 2, 3)))
}