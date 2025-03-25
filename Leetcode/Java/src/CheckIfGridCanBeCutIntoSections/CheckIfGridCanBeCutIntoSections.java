package CheckIfGridCanBeCutIntoSections;

// https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    // We define a rectangle using (x1, y1, x2, y2), and in the real world,
    // a rectangle is simply 2 sides in the x-axis and the same in the y-axis.
    // Each side of them can be considered as an interval on that axis. For
    // example, the rectangle (1,0,5,2) has:
    // 1. 2 sides on the x-axis starts with 1 and ends with 5.
    // 2. 2 sides on the y-axis starts with 0 and ends with 2.

    // Thus, each rectangle can be considered as two rectangles on both axes.
    // Using this fact, we can form two arrays, one for the intervals of the
    // x-axis, and for the intervals of y-axis. Then, check if we can split it
    // using 2 horizontal cut points with the x-axis array. If we can't, check
    // if we can split it using 2 vertical cut points with the y-axis array.

    // To check if we can split the intervals using two cut points, we need
    // to make sure that at least there are 3 or more rectangles that aren't
    // overlapping to split after them.

    // Time: O(n * log n)
    // Space: O(1), but note that the sorting will take extra space.
    public boolean checkValidCuts(int n, int[][] rectangles) {
        // Get the number of rectangles
        int size = rectangles.length;

        // Define an array to store the intervals on each axis.
        int[][] axisX = new int[size][2]; // (x1, x2)
        int[][] axisY = new int[size][2]; // (y1, y2)

        // Unpack the intervals of each rectangle to fill the arrays.
        int i = 0;
        for (int[] rect : rectangles) {
            axisX[i] = new int[]{rect[0], rect[2]};
            axisY[i] = new int[]{rect[1], rect[3]};
            i++;
        }

        // Sort the intervals based on the starting point, before counting the overlapping intervals.
        Arrays.sort(axisX, Comparator.comparingInt(a -> a[0]));

        // If there are at least 3 non-overlapping intervals (rectangles) on the
        // x-axis, then we can split these intervals using 2 horizontal cut points.
        if (nonOverlappingCount(axisX) >= 3) {
            return true;
        }

        // If we can't split using a horizontal cut points, try using vertical
        // cut points by checking the y-axis intervals.
        Arrays.sort(axisY, Comparator.comparingInt(a -> a[0]));
        return nonOverlappingCount(axisY) >= 3;
    }

    // Count the non-overlapping intervals on any axis.
    private int nonOverlappingCount(int[][] intervals) {
        int count = 0;
        int prevEnd = -1; // Store the previous ending point.

        for (int[] interval : intervals) {
            // If the current starting point is after the previous ending point, or
            // at least is equal to it, then the current interval doesn't overlap
            // with any interval before it.
            if (interval[0] >= prevEnd) {
                count++;
            }

            // Update the previous ending point with the latest ending point.
            prevEnd = Math.max(prevEnd, interval[1]);
        }

        return count;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(
                sol.checkValidCuts(
                        5,
                        new int[][]{
                                {1, 0, 5, 2},
                                {0, 2, 2, 4},
                                {3, 2, 5, 3},
                                {0, 4, 4, 5}
                        }
                )
        );

        System.out.println(
                sol.checkValidCuts(
                        4,
                        new int[][]{
                                {0, 0, 1, 1},
                                {2, 0, 3, 4},
                                {0, 2, 2, 3},
                                {3, 0, 4, 3}
                        }
                )
        );

        System.out.println(
                sol.checkValidCuts(
                        4,
                        new int[][]{
                                {0, 2, 2, 4},
                                {1, 0, 3, 2},
                                {2, 2, 3, 4},
                                {3, 0, 4, 2},
                                {3, 2, 4, 4}
                        }
                )
        );
    }
}