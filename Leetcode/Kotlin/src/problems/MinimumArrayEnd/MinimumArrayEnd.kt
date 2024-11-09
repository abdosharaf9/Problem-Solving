package problems.MinimumArrayEnd

// https://leetcode.com/problems/minimum-array-end/

private class Solution {
    fun minEnd(n: Int, x: Int): Long {
        val n = n.toLong()
        val x = x.toLong()
        var res = x

        var i_x = 1L
        var i_n = 1L

        while (i_n < n) {
            if (i_x and x == 0L) {
                if (i_n and (n - 1) != 0L) {
                    res = res or i_x
                }

                i_n = i_n.shl(1)
            }

            i_x = i_x.shl(1)
        }

        return res
    }

    /*fun minEnd(n: Int, x: Int): Long {
        val x = x.toLong()
        var res = x

        repeat(n - 1) {
            res = (res + 1) or x
        }

        return res
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.minEnd(3, 4))
    println(sol.minEnd(2, 7))
}