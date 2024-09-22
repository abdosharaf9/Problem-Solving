package KthSmallestInLexicographicalOrder;

// https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/

class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1; // Start with the smallest lexicographical number, which is 1.
        k--; // Decrement k by 1 since we're already at the first number (cur = 1).

        // Loop until we find the k-th number.
        while (k > 0) {
            // Count how many numbers are between cur and cur + 1 in lexicographical order.
            int steps = countSteps(cur, n);

            // If there are fewer or equal numbers than k in this range, skip this subtree.
            if (steps <= k) {
                cur++; // Move to the next sibling node (next number in the same level).
                k -= steps; // Decrease k by the number of steps we've skipped.
            } else {
                // Otherwise, move down to the next level of the tree (i.e., go deeper).
                cur *= 10; // Move to the first child of the current node.
                k--; // We used one step to move deeper.
            }
        }

        return cur; // Return the k-th lexicographical number.
    }

    // This function counts how many numbers are lexicographically between `cur` and `cur + 1` that are <= n.
    private int countSteps(int cur, int n) {
        int steps = 0; // Initialize the number of steps (numbers) found.
        long first = cur; // The smallest number in the current subtree starting at `cur`.
        long last = cur; // The largest number in the current subtree starting at `cur`.

        // While `first` is within the bounds of `n`.
        while (first <= n) {
            // Add to steps the number of valid numbers in the current range.
            // The range is [first, last] but we can't go beyond n, so we use min(n + 1, last + 1).
            steps += (int) (Math.min(n + 1, last + 1) - first);

            // Move to the next level of the tree:
            // Multiply `first` by 10 to go to the next level (e.g., from `1` to `10`).
            first *= 10;
            // Expand the range by setting `last = last * 10 + 9` (e.g., from `1` to `19`).
            last = last * 10 + 9;
        }

        // Return the total number of steps (numbers) between `cur` and `cur + 1` that are <= n.
        return steps;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findKthNumber(13, 2));
        System.out.println(sol.findKthNumber(1, 1));
        System.out.println(sol.findKthNumber(1000000000, 1000000000));
    }
}