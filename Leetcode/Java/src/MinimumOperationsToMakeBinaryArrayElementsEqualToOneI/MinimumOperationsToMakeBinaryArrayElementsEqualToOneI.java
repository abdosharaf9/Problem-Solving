package MinimumOperationsToMakeBinaryArrayElementsEqualToOneI;

// https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/

class Solution {
    // Time: O(n)
    // Space: O(1)
    public int minOperations(int[] nums) {
        // Count the number of flips used to convert the whole array.
        int lastIdx = nums.length - 1;
        int flips = 0;

        // Loop over all the elements without the last 2 to simulate
        // checking each window of size 3 that starts at index i.
        for (int i = 0; i <= lastIdx - 2; i++) {
            // If the current element is 0, flip the whole window and
            // update the number of flips.
            if (nums[i] == 0) {
                nums[i] = 1 - nums[i];
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
                flips += 1;
            }
        }

        // We guarantee that all the numbers are now 1, so we just check for the
        // last two, because we can't convert any one of them without converting
        // the numbers before them back to 0.
        if (nums[lastIdx] == 0 || nums[lastIdx - 1] == 0) {
            return -1;
        }

        return flips;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minOperations(new int[]{0, 1, 1, 1, 0, 0}));
        System.out.println(sol.minOperations(new int[]{0, 1, 1, 1}));
    }
}