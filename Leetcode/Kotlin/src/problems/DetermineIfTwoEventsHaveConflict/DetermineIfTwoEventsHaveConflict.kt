package problems.DetermineIfTwoEventsHaveConflict

// https://leetcode.com/problems/determine-if-two-events-have-conflict/

private class Solution {

    // One line solution!
    /*fun haveConflict(event1: Array<String>, event2: Array<String>): Boolean {
        return event1[0] <= event2[1] && event2[0] <= event1[1]
    }*/

    fun haveConflict(event1: Array<String>, event2: Array<String>): Boolean {
        val e1 = convertTime(event1)
        val e2 = convertTime(event2)

        return e2.first <= e1.second && e2.second >= e1.first
    }

    private fun convertTime(event: Array<String>): Pair<Int, Int> {
        val start = event[0].split(":")
        val end = event[1].split(":")

        return Pair(
            start[0].toInt() * 60 + start[1].toInt(),
            end[0].toInt() * 60 + end[1].toInt()
        )
    }
}

fun main() {
    val sol = Solution()
    println(sol.haveConflict(arrayOf("01:15", "02:00"), arrayOf("02:00", "03:00")))
    println(sol.haveConflict(arrayOf("01:00", "02:00"), arrayOf("01:20", "03:00")))
    println(sol.haveConflict(arrayOf("10:00", "11:00"), arrayOf("14:00", "15:00")))
}