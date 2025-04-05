package LowestCommonAncestorOfDeepestLeaves;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Pair {
    TreeNode node;
    int depth;

    public Pair(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

class Solution {
    // Time: O(n)
    // Space: O(n), due to the recursion call stack.
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // Use a recursive DFS to visit each node and compute two things:
        //      1. The maximum depth found in that node’s subtree.
        //      2. The LCA of all deepest leaves in that subtree.
        // If both the left and right children return the same depth, then the
        // current node is their lowest common ancestor.
        Pair res = dfs(root, 0);
        return res.node;
    }

    public Pair dfs(TreeNode node, int depth) {
        // If the node is null, return a Pair with the same depth, because
        // we can't go deeper than this.
        if (node == null) {
            return new Pair(null, depth);
        }

        // Recursively get the LCA result for left and right children.
        Pair leftPair = dfs(node.left, depth + 1);
        Pair rightPair = dfs(node.right, depth + 1);

        // The deepest child will be the LCA of the current subtree.
        if (leftPair.depth > rightPair.depth) {
            return leftPair;
        } else if (rightPair.depth > leftPair.depth) {
            return rightPair;
        }

        // If both have the same depth, the current node is the LCA.
        return new Pair(node, leftPair.depth);
    }
}

class Test {
    public static void main(String[] args) {
        Integer[][] inputs = {
                {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4},
                {1},
                {0, 1, 3, null, 2}
        };

        Solution solution = new Solution();

        for (Integer[] input : inputs) {
            TreeNode root = buildTreeFromLevelOrder(input);
            TreeNode lca = solution.lcaDeepestLeaves(root);
            List<Integer> output = treeToLevelOrderList(lca);
            System.out.println(output);
        }
    }

    private static TreeNode buildTreeFromLevelOrder(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;

        while (!queue.isEmpty() && index < values.length) {
            TreeNode current = queue.poll();
            if (values[index] != null) {
                current.left = new TreeNode(values[index]);
                queue.offer(current.left);
            }
            index++;

            if (index < values.length && values[index] != null) {
                current.right = new TreeNode(values[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

    private static List<Integer> treeToLevelOrderList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                result.add(curr.val);
                queue.offer(curr.left);
                queue.offer(curr.right);
            } else {
                result.add(null);
            }
        }

        // Remove trailing nulls for clean output
        int i = result.size() - 1;
        while (i >= 0 && result.get(i) == null) {
            result.remove(i--);
        }

        return result;
    }
}
