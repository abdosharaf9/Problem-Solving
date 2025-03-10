package problems.CountOfSubstringsContainingEveryVowelAndKConsonantsII

// https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/

private class Solution {
    // The same solution, but using an array to store the frequencies
    // instead of the map, which improves the performance.
    // Time: O(n)
    // Space: O(1), actually we use an array to store the frequencies, but it just stores 26 characters.
    fun countOfSubstrings(word: String, k: Int): Long {
        // To check about the vowels in O(1) time easily.
        val vowels = setOf('a', 'e', 'i', 'o', 'u')

        // Traditional Sliding Window to count the substrings contains at least k constants.
        fun countWindowsWithAtLeastKCons(cons: Int): Long {
            // Store the frequency of the current vowels and constants.
            val curVowels = IntArray(26)
            var curCons = 0

            // Check if the current window has every vowel.
            fun checkVowels(): Boolean {
                return curVowels['a' - 'a'] > 0 &&
                        curVowels['e' - 'a'] > 0 &&
                        curVowels['i' - 'a'] > 0 &&
                        curVowels['o' - 'a'] > 0 &&
                        curVowels['u' - 'a'] > 0
            }

            // Initialize the left pointer, and the result.
            var left = 0
            var res = 0L

            for (r in word.indices) {
                // Update the frequencies.
                if (vowels.contains(word[r])) {
                    curVowels[word[r] - 'a']++
                } else {
                    curCons++
                }

                // While the current window is valid, increase the result and shrink
                // the window from the left to try a new starting point.
                while (checkVowels() && curCons >= cons) {
                    // Because the window doesn't have to be of a fixed size, so we are
                    // sure that evey coming window that starts at the left pointer and
                    // contains the right pointer will be valid as well. Thus, count them
                    // in a single iteration and start a new window.
                    res += word.length - r

                    // Update the frequencies after shrinking the window from the left.
                    if (vowels.contains(word[left])) {
                        curVowels[word[left] - 'a']--
                    } else {
                        curCons--
                    }

                    // Shrink the window.
                    left++
                }
            }

            return res
        }

        // Suppose we have a function that tells us the number of substrings with
        // at least k constants. If we get the number of substrings with at least
        // k+1 constants, we can subtract them to get the number of substrings with
        // exactly k constants.
        // At least k:          *********************>
        // At least k+1:           ******************>
        // Function line: --------------------------->
        // The difference between the lines in the previous comment is k itself.
        return countWindowsWithAtLeastKCons(k) - countWindowsWithAtLeastKCons(k + 1)
    }

    // Time: O(n)
    // Space: O(1), actually we use a map to store the frequencies, but it just stores 5 characters.
    /*fun countOfSubstrings(word: String, k: Int): Long {
        // To check about the vowels in O(1) time easily.
        val vowels = setOf('a', 'e', 'i', 'o', 'u')

        // Traditional Sliding Window to count the substrings contains at least k constants.
        fun countWindowsWithAtLeastKCons(cons: Int): Long {
            // Store the frequency of the current vowels and constants.
            val curVowels = mutableMapOf<Char, Int>()
            var curCons = 0

            // Initialize the left pointer, and the result.
            var left = 0
            var res = 0L

            for (r in word.indices) {
                // Update the frequencies.
                if (vowels.contains(word[r])) {
                    curVowels[word[r]] = (curVowels[word[r]] ?: 0) + 1
                } else {
                    curCons++
                }

                // While the current window is valid, increase the result and shrink
                // the window from the left to try a new starting point.
                while (curVowels.size == 5 && curCons >= cons) {
                    // Because the window doesn't have to be of a fixed size, so we are
                    // sure that evey coming window that starts at the left pointer and
                    // contains the right pointer will be valid as well. Thus, count them
                    // in a single iteration and start a new window.
                    res += word.length - r

                    // Update the frequencies after shrinking the window from the left.
                    if (vowels.contains(word[left])) {
                        // Note that we remove the character with 0 frequency, because we
                        // check about the map size to make it much easier.
                        val old = curVowels[word[left]]!!

                        if (old == 1) {
                            curVowels.remove(word[left])
                        } else {
                            curVowels[word[left]] = old - 1
                        }
                    } else {
                        curCons--
                    }

                    // Shrink the window.
                    left++
                }
            }

            return res
        }

        // Suppose we have a function that tells us the number of substrings with
        // at least k constants. If we get the number of substrings with at least
        // k+1 constants, we can subtract them to get the number of substrings with
        // exactly k constants.
        // At least k:          *********************>
        // At least k+1:           ******************>
        // Function line: --------------------------->
        // The difference between the lines in the previous comment is k itself.
        return countWindowsWithAtLeastKCons(k) - countWindowsWithAtLeastKCons(k + 1)
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.countOfSubstrings("aeioqq", 1))
    println(sol.countOfSubstrings("aeiou", 0))
    println(sol.countOfSubstrings("ieaouqqieaouqq", 1))
}