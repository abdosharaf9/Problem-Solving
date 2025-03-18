package LongestNiceSubarray;

// https://leetcode.com/problems/longest-nice-subarray/

class Solution {
    // Time: O(n)
    // Space: O(1)
    public int longestNiceSubarray(int[] nums) {
        // Initialize the left pointer, the result, and the current window
        // bitmask which stores the bits that are set.
        int left = 0;
        int cur = 0;
        int max = 0;

        for (int right = 0; right < nums.length; right++) {
            // If the new window isn't valid, shrink it before adding the new number.
            while ((nums[right] & cur) != 0) {
                // Use XOR to unset the bits of the left number, and then shift the pointer.
                cur ^= nums[left];
                left++;
            }

            // Use OR to set the bits of the new number. Note that we can use XOR here
            // also, because we are sure that there won't be any overlapping bits.
            cur |= nums[right];

            // Try to maximize the result.
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestNiceSubarray(new int[]{1, 3, 8, 48, 10}));
        System.out.println(sol.longestNiceSubarray(new int[]{3, 1, 5, 11, 13}));
    }
}