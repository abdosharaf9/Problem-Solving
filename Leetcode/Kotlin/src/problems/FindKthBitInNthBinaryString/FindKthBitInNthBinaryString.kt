package problems.FindKthBitInNthBinaryString

// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/

private class Solution {
    fun findKthBit(n: Int, k: Int): Char {
        if (k == 1) return '0'

        var s = "0"

        for (i in 2..n) {
            val new = invert(s).reversed()
            s += "1$new"
            println("S = $s")
        }

        return s[k - 1]
    }

    fun invert(s: String): String {
        return s.map { if (it == '0') '1' else '0' }.joinToString("")
    }
}

fun main() {
    val sol = Solution()
    println(sol.findKthBit(3, 1))
    println(sol.findKthBit(4, 11))
}