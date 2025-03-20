package MinimumOperationsToMakeBinaryArrayElementsEqualToOneII;

// https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-ii/

class Solution {
    // Time: O(n)
    // Space: O(1)
    public int minOperations(int[] nums) {
        // Store the number of flips.
        int flips = 0;

        // When a number is flipped two times, it gets back to the original value.
        // This happens with any even number of flips. Thus, any number will be
        // flipped only when it is flipped an odd number of times. To avoid modifying
        // the list over and over, we use the number of flips to know the current state
        // and check if it is 0 or not.
        // For example, 0 -> 1 -> 0 -> 1 ...etc.
        for (int num : nums) {
            // (flips % 2) will return 0 if the number of flips is even and 1 if it is odd.
            // The XOR operator will flip the number if it is used with 1 and leave it as it
            // is when used with 0. Thus, if the number of flips is even (flips % 2) will pass
            // 0 to the XOR, which leaves the current number as it is, and will return 1 if the
            // number is odd, which flips the number.
            // Only increment the flips if the current number is 0.
            if (((flips % 2) ^ num) == 0) {
                flips += 1;
            }
        }

        return flips;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minOperations(new int[]{0, 1, 1, 0, 1}));
        System.out.println(sol.minOperations(new int[]{1, 0, 0, 0}));
    }
}