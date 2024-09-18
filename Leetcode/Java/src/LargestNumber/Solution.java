package LargestNumber;

// https://leetcode.com/problems/largest-number/

import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        String[] newList = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newList[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(newList, (a, b) -> (b + a).compareTo(a + b));

        if (newList[0].equals("0")) return "0";

        StringBuilder result = new StringBuilder();
        for (String s : newList) {
            result.append(s);
        }

        return result.toString();
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.largestNumber(new int[]{10, 2}));
        System.out.println(sol.largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(sol.largestNumber(new int[]{0, 0, 0}));
    }
}