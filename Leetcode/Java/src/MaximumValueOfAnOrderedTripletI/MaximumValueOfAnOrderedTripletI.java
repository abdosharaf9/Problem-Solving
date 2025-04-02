package MaximumValueOfAnOrderedTripletI;

// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/

class Solution {
    // Time: O(n)
    // Space: O(1)
    public long maximumTripletValue(int[] nums) {
        // Store the maximum result we found so far.
        long max = 0;

        // Store the maximum value for nums[i] & (nums[i] - nums[j]) to get rid of both loops.
        int left = 0;
        int maxDiff = 0;

        for (int num : nums) {
            // Apply the formula and maximize the result.
            max = Math.max(max, (long) maxDiff * num);

            // Maximize the (nums[i] - nums[j]) value.
            maxDiff = Math.max(maxDiff, left - num);

            // Maximize the nums[i] value
            left = Math.max(left, num);
        }

        return max;
    }

    // Time: O(n^2)
    // Space: O(1)
    /*public long maximumTripletValue(int[] nums) {
        // Store the maximum result we found so far.
        int n = nums.length;
        long max = 0;

        // Store the maximum value for nums[i] to get rid of the first loop.
        int left = nums[0];

        // Loop over all the j & k possible values.
        for (int j = 1; j < n - 1; j++) {
            // If we find a new nums[i] value, store it and continue to the next
            // iteration, because we are sure there is no need to do the inner loop.
            if (nums[j] > left) {
                left = nums[j];
                continue;
            }

            for (int k = j + 1; k < n; k++) {
                // Apply the formula and maximize the result.
                long cur = (left - nums[j]) * (long) nums[k];
                max = Math.max(max, cur);
            }
        }

        return max;
    }*/

    // Time: O(n^3)
    // Space: O(1)
    /*public long maximumTripletValue(int[] nums) {
        // Store the maximum result we found so far.
        int n = nums.length;
        long max = 0;

        // Brute force all the triplets to find the one with the maximum value.
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Apply the formula and maximize the result.
                    long cur = (nums[i] - nums[j]) * (long) nums[k];
                    max = Math.max(max, cur);
                }
            }
        }

        return max;
    }*/
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maximumTripletValue(new int[]{12, 6, 1, 2, 7}));
        System.out.println(sol.maximumTripletValue(new int[]{1, 10, 3, 4, 19}));
        System.out.println(sol.maximumTripletValue(new int[]{1, 2, 3}));
    }
}