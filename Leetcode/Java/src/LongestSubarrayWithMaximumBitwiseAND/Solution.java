package LongestSubarrayWithMaximumBitwiseAND;

// https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/

class Solution {
    public int longestSubarray(int[] nums) {
        int result = 1;

        int max = nums[0];
        for (int x : nums) {
            if (x > max) max = x;
        }

        int temp = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] && nums[i] == max) {
                temp++;
                if (temp > result) result = temp;
            } else {
                temp = 1;
            }
        }

        return result;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestSubarray(new int[]{1, 2, 3, 3, 2, 2}));
        System.out.println(sol.longestSubarray(new int[]{1, 2, 3, 4}));
    }
}
