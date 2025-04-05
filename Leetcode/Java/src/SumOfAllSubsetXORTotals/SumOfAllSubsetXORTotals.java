package SumOfAllSubsetXORTotals;

// https://leetcode.com/problems/sum-of-all-subset-xor-totals/

class Solution {
    // Time: O(n)
    // Space: O(1)
    public int subsetXORSum(int[] nums) {
        // If we take the XOR of all the numbers, we will find that each bit in each
        // number appears in half of all subsets only. If the size is n, the number of
        // subsets will be 2^n. Then, half of that number will be 2^(n-1).
        // For a single bit position (like 2^0, 2^1...), it will contribute to the XOR
        // in half of the total subsets if it is set in any number.

        // The OR collects all bits that appear in any number, because XOR can only be 1
        // if the bit appears an odd number of times.

        // Each unique XOR combination can be thought of as appearing 2^(n-1) times. Therefore,
        // multiply the cumulative XOR of all bit positions by 2^(n-1) using bit shift.
        int res = 0;
        for (int n : nums) {
            res |= n;
        }

        return res << (nums.length - 1);
    }

    // Time: O(2^n)
    // Space: O(n), due to the call stack.
    /*public int subsetXORSum(int[] nums) {
        // Start DFS from index 0 with an initial XOR total of 0.
        return dfs(0, 0, nums);
    }

    // Use recursive DFS to explore two choices at each step:
    // 1. Include the current element in the subset, and XOR it with the total.
    // 2. Exclude the current element, and leave the total unchanged.
    private int dfs(int i, int total, int[] nums) {
        // If we reached the end of the array, return the current XOR total.
        if (i == nums.length) {
            return total;
        }

        // We have 2 options:
        // Option 1: include nums[i] in the subset, XOR it with current total.
        // Option 2: exclude nums[i], keep the total unchanged.
        // Calculate both of them and return the summation.
        return dfs(i + 1, total ^ nums[i], nums) + dfs(i + 1, total, nums);
    }*/
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.subsetXORSum(new int[]{1, 3}));
        System.out.println(sol.subsetXORSum(new int[]{5, 1, 6}));
        System.out.println(sol.subsetXORSum(new int[]{3, 4, 5, 6, 7, 8}));
    }
}