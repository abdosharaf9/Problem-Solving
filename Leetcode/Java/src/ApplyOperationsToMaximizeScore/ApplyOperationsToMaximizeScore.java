package ApplyOperationsToMaximizeScore;

// https://leetcode.com/problems/apply-operations-to-maximize-score/

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class Solution {
    private final int MOD = 1_000_000_007;

    // Time: O((n * sqrt(m)) + (n * log n)), where m is the maximum number in the list.
    // Space: O(n)
    public int maximumScore(List<Integer> nums, int k) {
        // 1. Get the prime score of each number boundaries
        // 2. Use Monotonic Decreasing Stack to get the left and right
        //    bounds of the largest window that each number can be part of
        // 3. Use Max Heap to select the maximum number each time

        // Get the list size.
        int n = nums.size();

        // Calculate the prime score of each number.
        int[] primeScores = new int[n];
        for (int i = 0; i < n; i++) {
            primeScores[i] = calcPrimeScore(nums.get(i));
        }

        // Used as a Monotonic Decreasing Stack to get for each number:
        //      1. first number with smaller score to the left, which will be the window start.
        //      2. first number with larger score to the right, which will be the window end.
        // This is used to define the maximum possible window bounds for each number,
        // because that maximum window will contain all the valid windows for that number.
        // Note that we will store the indices, not the numbers themselves.
        Stack<Integer> stack = new Stack<>();

        // Store the left and right window bounds for each number. Note that we will store
        // the indices, not the numbers themselves.
        int[] leftBound = new int[n];
        int[] rightBound = new int[n];

        // Initialize the left bound for all as -1, and the right as n (size of the array).
        Arrays.fill(leftBound, -1);
        Arrays.fill(rightBound, n);

        // Calculate the left and right window bounds.
        for (int i = 0; i < n; i++) {
            // If the current number has a larger score than the stack's top, pop from the
            // stack to preserve the decreasing order. The current index will be the right
            // bound index for the number we popped.
            while (!stack.isEmpty() && primeScores[stack.peek()] < primeScores[i]) {
                int idx = stack.pop();
                rightBound[idx] = i;
            }

            // If the stack is not empty, this means there is still numbers with a larger score
            // in the stack. The first one to the left of the current number will be the top.
            if (!stack.isEmpty()) {
                leftBound[i] = stack.peek();
            }

            // Add the current index to the stack.
            stack.push(i);
        }

        // Store all the numbers in a Maximum Heap to sort them in decreasing order.
        // For each number, we add (number, index) to get its index later.
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            heap.add(new int[]{nums.get(i), i});
        }

        // Initialize the result.
        long res = 1;

        // Perform the operation k times.
        while (k > 0 && !heap.isEmpty()) {
            // Get the maximum value in the heap.
            int[] max = heap.poll();
            int num = max[0], idx = max[1];

            // Calculate the count of numbers to the left and to the right of the current
            // number. These are used to calculate the number of windows the current number
            // can be part of. The numbers to the right are considered the number of starting
            // points, and the numbers to the left are considered ending points. Thus, the number
            // of windows will be (left count * right count).
            int leftCount = idx - leftBound[idx];
            int rightCount = rightBound[idx] - idx;

            // The number of windows is used to know how many times we can use the current number
            // to increase the score. If the number of windows is smaller than k, then increase
            // the score by windows count times and decrease k. If k is smaller than windows
            // count, then just apply the operation k times because we can't use it more than k.
            long operations = Math.min((long) leftCount * rightCount, k);

            // The increment in the score will be: "score * cur * cur * cur...etc."
            // according to the count of the operations we can perform"
            // This is equal to: "score * (cur) ^ operations"
            // where "cur" is the current largest number.
            // Note that we used a custom power function to get the answer modulo.
            res = (res * power(num, operations)) % MOD;

            // Decrement k with the number of operations we performed.
            k -= (int) operations;
        }

        return (int) res;
    }

    // Calculate the prime score of the input number.
    private static int calcPrimeScore(int num) {
        int score = 0;

        // Loop over the numbers that can be a factor of num. Their range is
        // the numbers between 2 and sqrt(num), because all the numbers larger
        // than that must be multiplied by a number smaller than sqrt(num).
        for (int factor = 2; factor <= (int) Math.sqrt(num); factor++) {
            // If the current number is a factor of num, increase the score.
            if (num % factor == 0) {
                score += 1;

                // Decrease num until it can't be divided by the factor.
                while (num % factor == 0) {
                    num /= factor;
                }
            }
        }

        // If num is still bigger than one, then add 1 to the score to get the right score.
        if (num >= 2) {
            score += 1;
        }

        return score;
    }

    // Calculate (base ^ exponent) % MOD.
    private long power(long base, long exponent) {
        long res = 1;

        // Calculate the exponentiation using binary exponentiation.
        while (exponent > 0) {
            // If the exponent is odd, multiply the result by the base.
            if (exponent % 2 == 1) {
                res = (res * base) % MOD;
            }

            // Square the base and halve the exponent.
            base = (base * base) % MOD;
            exponent /= 2;
        }

        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maximumScore(List.of(8, 3, 9, 3, 8), 2));
        System.out.println(sol.maximumScore(List.of(19, 12, 14, 6, 10, 18), 3));
    }
}