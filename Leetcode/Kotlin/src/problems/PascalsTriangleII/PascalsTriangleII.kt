package problems.PascalsTriangleII

// https://leetcode.com/problems/pascals-triangle-ii/

private class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        val triangle = List(rowIndex + 1) { i -> MutableList(i + 1) { 1 } }

        for (row in 2..rowIndex) {
            for (col in 1..<triangle[row].lastIndex) {
                triangle[row][col] = triangle[row - 1][col - 1] + triangle[row - 1][col]
            }
        }

        return triangle[rowIndex]
    }

    /*fun getRow(rowIndex: Int): List<Int> {
        val triangle = mutableListOf<List<Int>>()
        triangle.add(listOf(1))

        repeat(rowIndex) {
            val row = mutableListOf(1)
            val lastRow = triangle.last()
            for (i in 1..lastRow.lastIndex) {
                row.add(lastRow[i - 1] + lastRow[i])
            }

            row.add(1)
            triangle.add(row)
        }

        return triangle.last()
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.getRow(3))
    println(sol.getRow(0))
    println(sol.getRow(1))
}