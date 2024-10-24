package problems.FlipEquivalentBinaryTrees

// https://leetcode.com/problems/flip-equivalent-binary-trees/

private class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

private class Solution {
    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        return if (root1 == null && root2 == null) true
        else if (root1 == null || root2 == null || root1.`val` != root2.`val`) false
        else (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))
    }
}

fun main() {
    val sol = Solution()

    val root1 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)

            right = TreeNode(5).apply {
                left = TreeNode(7)
                right = TreeNode(8)
            }
        }

        right = TreeNode(3).apply {
            left = TreeNode(6)
        }
    }

    val root2 = TreeNode(1).apply {
        left = TreeNode(3).apply {
            right = TreeNode(6)
        }

        right = TreeNode(2).apply {
            left = TreeNode(4)

            right = TreeNode(5).apply {
                left = TreeNode(8)
                right = TreeNode(7)
            }
        }
    }

    println(sol.flipEquiv(root1, root2))

    println(sol.flipEquiv(null, null))
    println(sol.flipEquiv(null, TreeNode(1)))
}