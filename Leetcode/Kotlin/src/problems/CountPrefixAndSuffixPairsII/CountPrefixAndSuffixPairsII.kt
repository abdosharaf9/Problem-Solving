package problems.CountPrefixAndSuffixPairsII

// https://leetcode.com/problems/count-prefix-and-suffix-pairs-ii/

// We used a Prefix and Suffix Trie at the same time because it is very
// complicated to use them separated.

// Each node of the trie will have a count of occurrences and its children.
// Children's map:
//      - Key: Pair<Char, Char> which represents the ith character of the
//        word along with the (size - i - 1)th character of the same word.
//      - value: the TrieNode it is associated with.

// The word "abc" will be represented as: [('a', 'c'), ('b', 'b'), ('c', 'a')].
private data class TrieNode(
    val children: MutableMap<Pair<Char, Char>, TrieNode> = mutableMapOf(),
    var count: Long = 0
)

private class Trie {
    val root = TrieNode()

    fun addWord(word: String) {
        var cur = root

        // zip function makes it easy to get pairs of the ith character
        // along with the (size - i - 1)th character.
        for ((s, e) in word.zip(word.reversed())) {
            // Create the node for the child if it is not created before.
            if (!cur.children.contains(s to e)) {
                cur.children[s to e] = TrieNode()
            }

            // Move the pointer to the child's node and increment its count.
            cur = cur.children[s to e]!!
            cur.count++
        }
    }

    // Traverse the trie using the word's pairs and return the count
    // of the last pair we will reach.
    fun getCount(word: String): Long {
        var cur = root

        for ((s, e) in word.zip(word.reversed())) {
            if (!cur.children.contains(s to e)) {
                return 0
            }

            cur = cur.children[s to e]!!
        }

        return cur.count
    }

    // The same as addWord, but instead of using a count function to get
    // the count, we can get it after adding the word and return it.
    fun addWord2(word: String): Long {
        var cur = root

        for ((s, e) in word.zip(word.reversed())) {
            if (!cur.children.contains(s to e)) {
                cur.children[s to e] = TrieNode()
            }

            cur = cur.children[s to e]!!
            cur.count++
        }

        // This -1 is because we added the word before returning the result.
        return cur.count - 1
    }
}

private class Solution {
    // Time: O(n * l), where l is the word's length.
    fun countPrefixSuffixPairs(words: Array<String>): Long {
        // Initialize the Trie and the result.
        val trie = Trie()
        var res = 0L

        // Loop over the words in reverse order because we just want
        // to check the word with its neighbors on the right, so looping
        // this way will be much easier.
        for (word in words.reversed()) {
            // Getting the count before adding the word to avoid
            // counting the word with itself.
            // res += trie.getCount(word)
            // trie.addWord(word)

            // Adding the word and get its count at the same time.
            res += trie.addWord2(word)
        }

        return res
    }
}


fun main() {
    val sol = Solution()
    println(sol.countPrefixSuffixPairs(arrayOf("a", "aba", "ababa", "aa")))
    println(sol.countPrefixSuffixPairs(arrayOf("pa", "papa", "ma", "mama")))
    println(sol.countPrefixSuffixPairs(arrayOf("abab", "ab")))
}