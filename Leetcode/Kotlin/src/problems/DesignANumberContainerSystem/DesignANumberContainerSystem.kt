package problems.DesignANumberContainerSystem

import java.util.PriorityQueue

// https://leetcode.com/problems/design-a-number-container-system/

// Time: O(Q * log n), where Q is the number of queries, and the O(log n) comes
// from using the Min Heap to add an index.
// Space: O(n)
private class NumberContainers() {

    // Store the number in each index, and the indices of each number.
    // Used Min Heap to get the minimum index in O(1).
    private val indicesMap = mutableMapOf<Int, Int>()
    private val numbersMap = mutableMapOf<Int, PriorityQueue<Int>>()

    fun change(index: Int, number: Int) { // O(log n)
        // If there was a number in that index already, remove the
        // current index from that number's heap.
        if (indicesMap.containsKey(index)) {
            val oldNumber = indicesMap[index]!!
            numbersMap[oldNumber]!!.remove(index)

            // If the old number's heap is empty, remove it.
            if (numbersMap[oldNumber]!!.size == 0) {
                numbersMap.remove(oldNumber)
            }
        }

        // Change the value stored at the index, and add it to the number's heap.
        indicesMap[index] = number
        numbersMap.computeIfAbsent(number) { PriorityQueue() }.add(index)
    }

    fun find(number: Int): Int { // O(1)
        // If the number doesn't exist, return -1.
        if (!numbersMap.containsKey(number)) {
            return -1
        }

        // Return the minimum index in which the number occurred.
        return numbersMap[number]!!.peek()
    }

}

fun main() {
    val sys = NumberContainers()
    println(sys.find(10))
    println(sys.change(2, 10))
    println(sys.change(1, 10))
    println(sys.change(3, 10))
    println(sys.change(5, 10))
    println(sys.find(10))
    println(sys.change(1, 20))
    println(sys.find(10))
}