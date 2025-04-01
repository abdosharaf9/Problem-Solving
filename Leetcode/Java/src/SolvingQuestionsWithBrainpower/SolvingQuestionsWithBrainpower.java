package SolvingQuestionsWithBrainpower;

// https://leetcode.com/problems/solving-questions-with-brainpower/

// Dynamic Programming Bottom-Up
// Time: O(n)
// Space: O(n)
class Solution {
    public long mostPoints(int[][] questions) {
        // Store the computed states.
        int n = questions.length;
        long[] dp = new long[n];

        // Loop in backwards to solve the smaller subproblems first.
        for (int i = n - 1; i >= 0; i--) {
            // Calculate the points if we take the current question. Note that
            // when we take a question, we must skip the next x questions.
            long take = questions[i][0];
            if (i + 1 + questions[i][1] < n) { // Make sure we are in bounds.
                take += dp[i + 1 + questions[i][1]];
            }

            // Calculate the points if we skip the current question.
            long skip = 0;
            if (i + 1 < n) { // Make sure we are in bounds.
                skip += dp[i + 1];
            }

            // Store the result of the current subproblem.
            dp[i] = Math.max(take, skip);
        }

        // Return the answer if we start with the first question.
        return dp[0];
    }
}

// Dynamic Programming Top-Down
// Time: O(n)
// Space: O(n)
/*class Solution {
    // Store the computed states.
    long[] dp;

    public long mostPoints(int[][] questions) {
        // Initialize the array.
        dp = new long[questions.length];

        // Return the answer if we start with the first question.
        return solve(0, questions);
    }

    private long solve(int i, int[][] questions) {
        // If we get out of bounds, return 0.
        if (i >= questions.length) {
            return 0;
        }

        // Return the pre-computed results.
        if (dp[i] != 0L) {
            return dp[i];
        }

        // Calculate the points if we take or skip the current question. Note
        // that when we take a question, we must skip the next x questions.
        long take = questions[i][0] + solve(i + 1 + questions[i][1], questions);
        long skip = solve(i + 1, questions);

        // Store the result, and return it.
        dp[i] = Math.max(take, skip);
        return dp[i];
    }
}*/

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(
                sol.mostPoints(
                        new int[][]{
                                {3, 2},
                                {4, 3},
                                {4, 4},
                                {2, 5}
                        }
                )
        );

        System.out.println(
                sol.mostPoints(
                        new int[][]{
                                {1, 1},
                                {2, 2},
                                {3, 3},
                                {4, 4},
                                {5, 5}
                        }
                )
        );
    }
}