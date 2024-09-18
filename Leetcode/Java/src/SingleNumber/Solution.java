package SingleNumber;

// https://leetcode.com/problems/single-number/

class Solution {
    public int singleNumber(int[] nums) {
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.singleNumber(new int[]{2, 2, 1}));
        System.out.println(sol.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(sol.singleNumber(new int[]{1}));
    }
}