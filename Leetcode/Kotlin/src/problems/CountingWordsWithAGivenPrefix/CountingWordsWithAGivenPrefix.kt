package problems.CountingWordsWithAGivenPrefix

// https://leetcode.com/problems/counting-words-with-a-given-prefix/

// Implementing a classic Prefix Tree (Trie), and each node will
// have a count that tells us how many words contains this character.
private data class Node(
    // We have only lowercase English letters, so we use 26 places.
    val children: Array<Node?> = Array(26) { null },
    var count: Int = 0
)

private class PrefixTree {
    val root = Node()

    fun addWord(word: String) {
        var cur = root

        for (c in word) {
            // Creating a node for the child character if there is not.
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = Node()
            }

            // Moving to the child character and increment its count.
            cur = cur.children[c - 'a']!!
            cur.count++
        }
    }

    fun getCount(word: String): Int {
        var cur = root

        for (c in word) {
            // If the child character doesn't exist, there is no
            // word has this prefix, so we return 0.
            if (cur.children[c - 'a'] == null) {
                return 0
            }

            cur = cur.children[c - 'a']!!
        }

        // Return the count of the last character count.
        return cur.count
    }
}

private class Solution {
    // Using a Prefix Tree (Trie) which adds an overhead of creating a new
    // data structure and using the Heap memory to save all these objects.
    // Time: O(n * l + m), where "n" is the number of words, "l" is the word
    // length, and "m" is the pref length.
    // Space: O(n * l), which is the overall characters count.

    // We can improve the time and space complexity by only loop over the
    // first "m" characters of each word because we don't need the rest.
    // The time will be: O(n * m + m), and the space: O(n * m).
    fun prefixCount(words: Array<String>, pref: String): Int {
        val prefixTree = PrefixTree()

        // Adding all the words to the prefix tree.
        for (word in words) {
            prefixTree.addWord(word)
        }

        // Getting how many words that contain the pref in the beginning.
        return prefixTree.getCount(pref)
    }

    // Brute Force solution which will be more efficient for this
    // problem because of the small input sizes.
    // Time: O(n * l), where l is the prefix length.
    // Space: O(1)
    /*fun prefixCount(words: Array<String>, pref: String): Int {
        // Loop over all the words and increment the counter if the
        // current word starts with the pref string.
        var res = 0
        for (word in words) {
            if (word.startsWith(pref)) {
                res++
            }
        }
        return res

        // Use the count function to do the same in one line.
        // return words.count { it.startsWith(pref) }
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.prefixCount(arrayOf("pay", "attention", "practice", "attend"), "at"))
    println(sol.prefixCount(arrayOf("leetcode", "win", "loops", "success"), "code"))
}