package MinimumNumberOfOperationsToMakeElementsInArrayDistinct;

// https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/

class Solution {
    // Time: O(n)
    // Space: O(1)
    public int minimumOperations(int[] nums) {
        // Mark the seen numbers.
        boolean[] lastSeen = new boolean[101];

        // Loop in backwards to know the starting of the unique part.
        for (int i = nums.length - 1; i >= 0; i--) {
            if (lastSeen[nums[i]]) {
                // We need to cut all the numbers from the first to the current index, and
                // each time we can remove 3 numbers only. So, count the number of operations
                // we need to remove all this part.
                return (i / 3) + 1;
            } else {
                lastSeen[nums[i]] = true;
            }
        }

        return 0;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minimumOperations(new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7}));
        System.out.println(sol.minimumOperations(new int[]{4, 5, 6, 4, 4}));
        System.out.println(sol.minimumOperations(new int[]{6, 7, 8, 9}));
    }
}
