package problems.SwapAdjacentInLRString

// https://leetcode.com/problems/swap-adjacent-in-lr-string/

private class Solution {
    fun canTransform(start: String, result: String): Boolean {
        val startList = mutableListOf<Pair<Char, Int>>()
        start.forEachIndexed { i, c ->
            if (c != 'X') startList.add(Pair(c, i))
        }

        val resultList = mutableListOf<Pair<Char, Int>>()
        result.forEachIndexed { i, c ->
            if (c != 'X') resultList.add(Pair(c, i))
        }

        if (startList.size != resultList.size) {
            return false
        }

        for (i in startList.indices) {
            val s = startList[i]
            val r = resultList[i]

            if (s.first != r.first) {
                return false
            }

            if (s.first == 'L' && s.second < r.second) {
                return false
            }

            if (s.first == 'R' && s.second > r.second) {
                return false
            }
        }

        return true
    }
}

fun main() {
    val sol = Solution()
    println(sol.canTransform("RXXLRXRXL", "XRLXXRRLX"))
    println(sol.canTransform("X", "L"))
}