package problems.RemoveSubFoldersFromTheFilesystem

// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/

private class Trie {

    val children = mutableMapOf<String, Trie>()
    var endOfFolder = false

    fun add(path: String) {
        var cur = this
        for (f in path.split("/")) {
            if (f !in cur.children) {
                cur.children[f] = Trie()
            }
            cur = cur.children[f]!!
        }
        cur.endOfFolder = true
    }

    fun search(path: String): Boolean {
        var cur = this
        val folders = path.split("/")
        for (i in 0..<folders.lastIndex) {
            cur = cur.children[folders[i]]!!
            if (cur.endOfFolder) return true
        }

        return false
    }
}

private class Solution {
    fun removeSubfolders(folder: Array<String>): List<String> {
        val trie = Trie()
        for (f in folder) trie.add(f)

        val result = mutableListOf<String>()
        for (f in folder) {
            if (!trie.search(f)) result.add(f)
        }

        return result
    }

    /*fun removeSubfolders(folder: Array<String>): List<String> {
        val set = folder.toSet()
        val result = mutableListOf<String>()

        for (f in folder) {
            result.add(f)
            for (i in f.indices) {
                if (f[i] == '/' && f.substring(0, i) in set) {
                    result.removeLast()
                    break
                }
            }
        }

        return result
    }*/
}

fun main() {
    val sol = Solution()
    println(sol.removeSubfolders(arrayOf("/a", "/a/b", "/c/d", "/c/d/e", "/c/f")))
    println(sol.removeSubfolders(arrayOf("/a", "/a/b/c", "/a/b/d")))
    println(sol.removeSubfolders(arrayOf("/a/b/c", "/a/b/ca", "/a/b/d")))
}