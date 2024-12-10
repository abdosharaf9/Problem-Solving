package problems.FindLongestSpecialSubstringThatOccursThriceII

// https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-ii/

private class Solution {
    // Time: O(n)
    // Space: O(n)
    fun maximumLength(s: String): Int {
        // Store the frequency for each special substring. We have only lowercase
        // letters (26) and each one at most can be used n times. The IntArray j
        // is used to store the frequency of ith character (arr[c-'a'][j]). For
        // example: "aaa" is represented as arr['a'-'a'][3], and we will use it to
        // store the frequency of "aaa".
        val n = s.length
        val arr = Array(26) { IntArray(n + 1) }

        // Used to know if we are still at the same substring.
        var lastSeen = s[0]
        var freq = 0

        for (c in s) {
            // If we still have the same character, we will increase the count,
            // and if not, we will start a new substring with initial count 1.
            if (c == lastSeen) {
                freq++
            } else {
                freq = 1
            }

            // Increase the frequency of the substring (c, count) by 1
            arr[c - 'a'][freq]++
            lastSeen = c
        }

        // Loop over all the special substrings we can have. The maximum
        // size of a substring is n, so we loop from n down to 1.
        var res = -1
        for (i in 0..25) {
            for (j in n downTo 1) {
                // If the substring arr[i][j] has a frequency x, we increase the
                // substring arr[i][j-1] frequency by x because this isn't counted
                // in the previous loop.
                arr[i][j - 1] += arr[i][j]

                // If the substring arr[i][j] occurs at least thrice, we see if it
                // has a bigger length to use it as the solution. We can break the
                // loop here because we know that the coming substrings will have
                // a smaller length even if they occur thrice.
                if (arr[i][j] >= 3) {
                    res = maxOf(res, j)
                    break
                }
            }
        }

        return res
    }
}

fun main() {
    val sol = Solution()
    println(sol.maximumLength("aaaa"))
    println(sol.maximumLength("abcdef"))
    println(sol.maximumLength("abcaba"))
    println(sol.maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde"))
}