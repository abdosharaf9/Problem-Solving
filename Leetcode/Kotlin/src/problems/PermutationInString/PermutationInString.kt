package problems.PermutationInString

// https://leetcode.com/problems/permutation-in-string/

private class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s2.length < s1.length) return false

        val firstCounts = IntArray(26) { 0 }
        val secondCounts = IntArray(26) { 0 }

        for (i in 0..s1.lastIndex) {
            firstCounts[s1[i] - 'a']++
            secondCounts[s2[i] - 'a']++
        }

        for (i in 0..<s2.length - s1.length) {
            if (firstCounts.contentEquals(secondCounts)) return true
            secondCounts[s2[i] - 'a']--
            secondCounts[s2[i + s1.length] - 'a']++
        }

        return firstCounts.contentEquals(secondCounts)
    }


    /*fun checkInclusion(s1: String, s2: String): Boolean {
        if (s2.length < s1.length) return false

        val firstSorted = s1.toCharArray().sorted().toString()
        var start = 0
        var end = s1.lastIndex

        while (end <= s2.lastIndex) {
            if (isPermutation(firstSorted, s2.substring(start, end + 1))) return true
            start++
            end++
        }

        return false
    }

    fun isPermutation(s1: String, s2: String) = s1 == s2.toCharArray().sorted().toString()*/
}

fun main() {
    val sol = Solution()
    println(sol.checkInclusion("ab", "eidbaooo"))
    println(sol.checkInclusion("ab", "eidboaoo"))
}