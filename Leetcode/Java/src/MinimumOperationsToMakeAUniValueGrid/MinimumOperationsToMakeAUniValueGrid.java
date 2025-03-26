package MinimumOperationsToMakeAUniValueGrid;

// https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/

import java.util.Arrays;

class Solution {
    // Time: O(m*n log m*n), because the heavy part here is the sorting.
    // Space: O(m * n)
    public int minOperations(int[][] grid, int x) {
        // 1. check if we can do that.
        // 2. flatten the array, and sort it.
        // 3. iterate over each number n in the array, and get the number of operations
        //    it would take us to convert all the numbers into n, and minimize the result.

        // Get the array dimensions.
        int rows = grid.length, cols = grid[0].length;

        // Initialize the new array to flatten the grid in.
        int[] arr = new int[rows * cols];

        // Store the total sum.
        int total = 0;

        // To check if we can convert all the numbers to a single value (any value):
        // Image that each number n in the array is a vector in a plane, because you
        // can change that number to be: ..., n-(2*x), n-x, n, n+x, n+(2*x), n+(3*x),...etc.
        // by either add/subtract x from it. Thus, any number in the array can be imagined as
        // a vector, because these values can form a straight line.

        // To convert all the numbers to a single value, this can only happen if their lines
        // are parallel. And we know that parallel lines have the same slope.

        // Therefore, to check if all the numbers can be converted into a single value or not,
        // we need to check if the slopes of all the numbers' lines are equal or not.

        int idx = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Checking if the slope is equal or not.
                if (grid[r][c] % x != grid[0][0] % x) {
                    // We can't convert all the numbers into a single value.
                    return -1;
                }

                // Add the current value to the flattened array, and update the total sum.
                arr[idx++] = grid[r][c];
                total += grid[r][c];
            }
        }

        // Sort the array to check the items from the smaller.
        Arrays.sort(arr);

        // Initialize the result.
        int res = Integer.MAX_VALUE;

        // Store the prefix sum of the numbers we tried so far.
        int prefix = 0;

        for (int i = 0; i < arr.length; i++) {
            // To calculate what the sum of the left and right portions must be after turning all
            // their values into arr[i], use this formula: (portion size * arr[i]).
            // After getting what the sums are supposed to be, we need to know what is the difference
            // between these values and the sum of the portions right now. This way we can know how
            // many operations we need to convert all the numbers of both portions to arr[i].
            int leftDiff = arr[i] * i - prefix;

            // Note that all the values to the right are bigger than arr[i].
            int rightDiff = total - prefix - (arr[i] * (arr.length - i));

            // Calculate the number of operations is needed, and minimize the result.
            int operations = (leftDiff + rightDiff) / x;
            res = Math.min(res, operations);

            // Update the prefix sum.
            prefix += arr[i];
        }

        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(
                sol.minOperations(
                        new int[][]{
                                {2, 4},
                                {6, 8}
                        },
                        2
                )
        );

        System.out.println(
                sol.minOperations(
                        new int[][]{
                                {1, 5},
                                {2, 3}
                        },
                        1
                )
        );

        System.out.println(
                sol.minOperations(
                        new int[][]{
                                {1, 2},
                                {3, 4}
                        },
                        2
                )
        );
    }
}