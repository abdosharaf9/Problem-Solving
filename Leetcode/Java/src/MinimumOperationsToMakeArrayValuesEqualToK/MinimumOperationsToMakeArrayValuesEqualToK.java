package MinimumOperationsToMakeArrayValuesEqualToK;

// https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/

import java.util.HashSet;

class Solution {
    // More efficient
    // Time: O(n)
    // Space: O(n)
    public int minOperations(int[] nums, int k) {
        // Mark numbers that are bigger than k.
        boolean[] bigger = new boolean[101];
        for (int num : nums) {
            // We can't have numbers smaller than k.
            if (num < k) return -1;
            else if (num > k) bigger[num] = true;
        }

        // Count unique numbers that are bigger than k.
        int count = 0;
        for (boolean value : bigger) {
            if (value) count++;
        }
        return count;
    }

    // Time: O(n)
    // Space: O(n)
    /*public int minOperations(int[] nums, int k) {
        // Store unique numbers that are bigger than k.
        HashSet<Integer> bigger = new HashSet<>();
        for (int num : nums) {
            // We can't have numbers smaller than k.
            if (num < k) return -1;
            else if (num > k) bigger.add(num);
        }
        // Return the count of unique numbers that are bigger than k.
        return bigger.size();
    }*/
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minOperations(new int[]{5, 2, 5, 4, 5}, 2));
        System.out.println(sol.minOperations(new int[]{2, 1, 2}, 2));
        System.out.println(sol.minOperations(new int[]{9, 7, 5, 3}, 1));
    }
}