package problems.MyCalendarII

import kotlin.math.max
import kotlin.math.min

// https://leetcode.com/problems/my-calendar-ii/

private class MyCalendarTwo {

    private val nonOverlapping = mutableListOf<Pair<Int, Int>>()
    private val overlapping = mutableListOf<Pair<Int, Int>>()

    fun book(start: Int, end: Int): Boolean {
        overlapping.forEach {
            if (start < it.second && end > it.first) return false
        }

        nonOverlapping.forEach {
            if (start < it.second && end > it.first) {
                overlapping.add(Pair(max(it.first, start), min(it.second, end)))
            }
        }

        nonOverlapping.add(Pair(start, end))
        return true
    }
}

fun main() {
    val cal = MyCalendarTwo()
    listOf(
        Pair(10, 20),
        Pair(50, 60),
        Pair(10, 40),
        Pair(5, 15),
        Pair(5, 10),
        Pair(25, 55)
    ).forEach {
        println(cal.book(it.first, it.second))
    }
}