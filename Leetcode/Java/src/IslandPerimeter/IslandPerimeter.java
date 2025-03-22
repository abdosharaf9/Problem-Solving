package IslandPerimeter;

// https://leetcode.com/problems/island-perimeter/

class Solution {
    // Time: O(n * m)
    // Space: O(1)
    public int islandPerimeter(int[][] grid) {
        // Store the four directions.
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        // Get the dimensions of the grid.
        int rows = grid.length, cols = grid[0].length;

        // Initialize the result.
        int res = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // If the current cell is an island, increment the result.
                if (grid[r][c] == 1) {
                    // Add the 4 sides temporarily.
                    res += 4;

                    // Check if there is a neighbor island to decrease the result.
                    for (int[] dir : dirs) {
                        // Calculate the neighbor indices.
                        int nr = r + dir[0], nc = c + dir[1];

                        // Check if the neighbor is in bounds, and is an island.
                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                            // Decrement the result.
                            res -= 1;
                        }
                    }
                }
            }
        }

        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(
                sol.islandPerimeter(
                        new int[][]{
                                {0, 1, 0, 0},
                                {1, 1, 1, 0},
                                {0, 1, 0, 0},
                                {1, 1, 0, 0}
                        }
                )
        );

        System.out.println(sol.islandPerimeter(new int[][]{{1}}));

        System.out.println(sol.islandPerimeter(new int[][]{{1, 0}}));
    }
}