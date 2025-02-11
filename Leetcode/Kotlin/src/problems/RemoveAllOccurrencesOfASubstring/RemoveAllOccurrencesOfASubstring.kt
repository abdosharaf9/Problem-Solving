package problems.RemoveAllOccurrencesOfASubstring

// https://leetcode.com/problems/remove-all-occurrences-of-a-substring/

private class Solution {
    // Time: O(n^2 / m), where n is the length of s, and m is the length of the part.
    // Space: O(1), because it doesn't use any space other than the result.
    fun removeOccurrences(s: String, part: String): String {
        // The result string initially is the input string.
        val res = StringBuilder(s)

        while (true) { // O(n / m)
            // The starting index of the part substring.
            val idx = res.indexOf(part) // O(n)

            // If there is no other occurrence of part string in s, break the loop.
            if (idx == -1) break

            // Remove the part string from the result.
            res.delete(idx, idx + part.length)
        }

        // Return the result after removing all the occurrences.
        return res.toString()
    }

    // Time: O(n^2 / m), where n is the length of s, and m is the length of the part.
    // Space: O(n), because is each iteration we form a new string.
    /*fun removeOccurrences(s: String, part: String): String {
        // The result string initially is the input string.
        var res = s

        // The starting index of the part substring.
        var idx = res.indexOf(part) // O(n)

        // Loop until there is no other occurrence of part string in s.
        while (res.isNotEmpty() && idx != -1) { // O(n / m)
            // Remove the part string from the result.
            res = res.substring(0, idx) + res.substring(idx + part.length) // O(n)

            // Get the starting index of the part other occurrence.
            idx = res.indexOf(part) // O(n)
        }

        // Return the result after removing all the occurrences.
        return res
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.removeOccurrences("daabcbaabcbc", "abc"))
    println(sol.removeOccurrences("axxxxyyyyb", "xy"))
}