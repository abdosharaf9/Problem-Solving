package MaximumValueOfAnOrderedTripletII;

// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/

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
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maximumTripletValue(new int[]{12, 6, 1, 2, 7}));
        System.out.println(sol.maximumTripletValue(new int[]{1, 10, 3, 4, 19}));
        System.out.println(sol.maximumTripletValue(new int[]{1, 2, 3}));
    }
}