package PartitionEqualSubsetSum;

// https://leetcode.com/problems/partition-equal-subset-sum/

import java.util.HashSet;

class Solution {
    // Time: O(n * sum)
    // Space: O(targetSum) ~ O(sum), but in a more efficient way.
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If the total sum is odd, it's not possible to partition it into two equal subsets.
        if (totalSum % 2 != 0) {
            return false;
        }

        // Our goal is to find if a subset sums up to half of the total sum.
        int targetSum = totalSum / 2;

        // dp[i] indicates whether a subset with sum 'i' is achievable.
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true; // Take 0 elements

        for (int num : nums) {
            // Traverse backwards to avoid using the same number multiple times.
            for (int currSum = targetSum; currSum >= num; currSum--) {
                dp[currSum] = dp[currSum] || dp[currSum - num];

                // Found a valid subset.
                if (dp[targetSum]) {
                    return true;
                }
            }
        }

        // Check if targetSum is achievable.
        return dp[targetSum];
    }

    // Time: O(n * sum)
    // Space: O(sum)
    /*public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If the total sum is odd, it's not possible to partition it into two equal subsets.
        if (totalSum % 2 != 0) {
            return false;
        }

        // Our goal is to find if a subset sums up to half of the total sum.
        int targetSum = totalSum / 2;

        // Track all possible subset sums we can form.
        HashSet<Integer> dp = new HashSet<>();
        dp.add(0); // Take 0 elements

        for (int num : nums) {
            // Take a copy to avoid modifying the set while iterating over it.
            HashSet<Integer> nextDp = new HashSet<>(dp);
            for (int x : dp) {
                // Found a valid subset.
                if (num + x == targetSum) {
                    return true;
                }

                nextDp.add(num + x);
            }

            // Update the possible sums.
            dp = nextDp;
        }

        // Check if the target sum exists in our possible sums.
        return dp.contains(targetSum);
    }*/
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(sol.canPartition(new int[]{1, 2, 3, 5}));
    }
}