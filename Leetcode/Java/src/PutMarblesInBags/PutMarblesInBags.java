package PutMarblesInBags;

// https://leetcode.com/problems/put-marbles-in-bags/

import java.util.Arrays;

class Solution {
    // Time: O(n * log n), because of the sorting.
    // Space: O(n)
    public long putMarbles(int[] weights, int k) {
        // If k is 1, all marbles must be in one bag, meaning min and max scores
        // are the same. So, the difference is 0.
        if (k == 1) {
            return 0;
        }

        // Store the array size.
        int n = weights.length;

        // Try to split the array at each index, and store the cost of that split.
        // Note that the cost of any split is the summation of the first and last
        // item in the bag. So, any split we will make must contain the first
        // and last item in the whole array anyway. Other than that, any index we
        // will split at, we will add the summation of the item at that index (the
        // end of the first bag) and the next item (the start of the next bag).
        long[] splits = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            splits[i] = (long) weights[i] + weights[i + 1];
        }

        // Sort the costs to get the maximum and minimum easily.
        Arrays.sort(splits);

        // Add the first k-1 minimum costs, and the k-1 maximum costs.
        long min = 0, max = 0;
        for (int i = 0; i < k - 1; i++) {
            min += splits[i];
            max += splits[n - i - 2];
        }

        // Return the score, which is the difference between the k-1 maximum and the k-1 minimum splits.
        return max - min;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.putMarbles(new int[]{1, 3, 5, 1}, 2));
        System.out.println(sol.putMarbles(new int[]{1, 3}, 2));
    }
}
