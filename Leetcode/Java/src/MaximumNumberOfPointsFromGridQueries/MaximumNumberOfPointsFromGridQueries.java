package MaximumNumberOfPointsFromGridQueries;

// https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static utils.ArrayUtils.printArray;

class Solution {
    // 1. Sort the queries array
    // 2. Answering the queries in ascending order will save us time
    //    because we traverse the grid only once

    // Time: O((m*n log m*n) + q log q), where m and n are the grid dimensions, and q is the number of queries.
    // Space: O(m * n)
    public int[] maxPoints(int[][] grid, int[] queries) {
        // Get the grid dimensions.
        int rows = grid.length, cols = grid[0].length;

        // Store the queries in ascending order and store its original index with it.
        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i] = new int[]{queries[i], i};
        }
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);

        // Used to store the cells we process in ascending order. Each
        // item will be an int array which is (value, row, column).
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Add the first cell to the heap, and mark it as visited.
        queue.add(new int[]{grid[0][0], 0, 0});
        grid[0][0] = -1;

        // Initialize the result array, and the points count.
        int[] res = new int[queries.length];
        int points = 0;

        // Solve the queries in ascending order because if we have these two
        // queries: [2, 3], we are sure that all the points we can collect
        // when the limit is 2 can also be collected when the limit is 3.
        // Thus, we don't need to repeat ourselves, so accumulate the result.
        for (int[] query : sortedQueries) {
            // Loop over all the cells we can use to collect points.
            while (!queue.isEmpty() && queue.peek()[0] < query[0]) {
                // Get the cell with the smallest value, and its indices.
                int[] cell = queue.poll();
                int r = cell[1], c = cell[2];

                // Add a point for this cell (collect it).
                points += 1;

                // Define this cell's neighbors.
                List<int[]> neighbors = List.of(new int[]{r - 1, c}, new int[]{r + 1, c}, new int[]{r, c - 1}, new int[]{r, c + 1});

                // Loop over the neighbors to add the unvisited cells.
                for (int[] nei : neighbors) {
                    // Get the indices of the neighbor.
                    int nr = nei[0], nc = nei[1];

                    // Add the neighbor to the heap only when it's in bounds, and it's unvisited.
                    if (
                            nr >= 0 && nr < rows &&
                                    nc >= 0 && nc < cols &&
                                    grid[nr][nc] != -1
                    ) {
                        // Add the neighbor to the heap, and mark it as visited.
                        queue.add(new int[]{grid[nr][nc], nr, nc});
                        grid[nr][nc] = -1;
                    }
                }
            }

            // Assign the collected points to the original index of the query.
            res[query[1]] = points;
        }

        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();

        printArray(
                sol.maxPoints(
                        new int[][]{
                                {1, 2, 3},
                                {2, 5, 7},
                                {3, 5, 1}
                        },
                        new int[]{5, 6, 2}
                )
        );

        printArray(
                sol.maxPoints(
                        new int[][]{
                                {5, 2, 1},
                                {1, 1, 2}
                        },
                        new int[]{3}
                )
        );
    }
}