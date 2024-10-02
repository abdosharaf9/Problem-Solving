package problems.LongestCommonPrefix

// https://leetcode.com/problems/longest-common-prefix/

private data class PrefixTreeNode(
    var count: Int = 0,
    val children: Array<PrefixTreeNode?> = arrayOfNulls(26)
)

private class Tree {

    private val root = PrefixTreeNode()

    fun insert(str: String) {
        var cur = root

        for (c in str) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = PrefixTreeNode()
            }

            cur = cur.children[c - 'a']!!
            cur.count++
        }
    }

    fun getPref(size: Int): String {
        var result = ""
        var cur = root

        while (true) {
            var changed = false
            for (i in 0..25) {
                if (cur.children[i] != null && cur.children[i]!!.count == size) {
                    result += 'a' + i
                    cur = cur.children[i]!!
                    changed = true
                    break
                }
            }

            if (!changed) break
        }

        return result
    }
}

private class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val tree = Tree()

        for (str in strs) {
            tree.insert(str)
        }

        return tree.getPref(strs.size)
    }
}

fun main() {
    val sol = Solution()
    println(sol.longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    println(sol.longestCommonPrefix(arrayOf("dog", "racecar", "car")))
}