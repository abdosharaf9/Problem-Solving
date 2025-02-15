package problems.FindThePunishmentNumberOfAnInteger

// https://leetcode.com/problems/find-the-punishment-number-of-an-integer/

private class Solution {
    fun punishmentNumber(n: Int): Int {
        fun canPartition(idx: Int, cur: Int, target: Int, str: String): Boolean {
            if (idx == str.length && cur == target) {
                return true
            }

            for (i in idx..str.lastIndex) {
                val newCur = str.substring(idx, i + 1).toInt() + cur
                if (canPartition(i + 1, newCur, target, str)) {
                    return true
                }
            }

            return false
        }

        var res = 0
        for (i in 1..n) {
            if (canPartition(0, 0, i, (i * i).toString())) {
                res += i * i
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.punishmentNumber(10))
    println(sol.punishmentNumber(37))
}