package problems.MovePiecesToObtainAString

// https://leetcode.com/problems/move-pieces-to-obtain-a-string/

private class Solution {
    // Time: O(n)
    // Space: O(m), which is number of unique characters
    fun canChange(start: String, target: String): Boolean {
        // Convert the string into a list of the character and its index
        val startList = mutableListOf<Pair<Char, Int>>()
        start.forEachIndexed { i, c ->
            if (c != '_') startList.add(Pair(c, i))
        }

        val targetList = mutableListOf<Pair<Char, Int>>()
        target.forEachIndexed { i, c ->
            if (c != '_') targetList.add(Pair(c, i))
        }

        // If they don't have the same size, they can't be matched
        if (startList.size != targetList.size) {
            return false
        }

        // Check if they are matched
        for (i in startList.indices) {
            val s = startList[i]
            val t = targetList[i]

            // If the current characters are not matched, the strings can't be matched
            // because L can't cross R anyway.
            if (s.first != t.first) {
                return false
            }

            // L can move only to the left. If it needs to move to the
            // right, they can't be matched.
            if (s.first == 'L' && s.second < t.second) {
                return false
            }

            // R can move only to the right. If it needs to move to the
            // left, they can't be matched.
            if (s.first == 'R' && s.second > t.second) {
                return false
            }
        }

        return true
    }
}

fun main() {
    val sol = Solution()
    println(sol.canChange("_L__R__R_", "L______RR"))
    println(sol.canChange("R_L_", "__LR"))
    println(sol.canChange("_R", "R_"))
}