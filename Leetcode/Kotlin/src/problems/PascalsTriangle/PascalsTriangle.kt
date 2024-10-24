package problems.PascalsTriangle

// https://leetcode.com/problems/pascals-triangle/

private class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val triangle = mutableListOf<List<Int>>()
        triangle.add(listOf(1))

        repeat(numRows - 1) {
            val row = mutableListOf(1)
            val lastRow = triangle.last()
            for (i in 1..lastRow.lastIndex) {
                row.add(lastRow[i - 1] + lastRow[i])
            }

            row.add(1)
            triangle.add(row)
        }

        return triangle
    }
}

fun main() {
    val sol = Solution()
    println(sol.generate(5))
    println(sol.generate(1))
}