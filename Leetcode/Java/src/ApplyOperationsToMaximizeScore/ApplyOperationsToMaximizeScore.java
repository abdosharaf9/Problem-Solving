package ApplyOperationsToMaximizeScore;

// https://leetcode.com/problems/apply-operations-to-maximize-score/

class Solution {
    int MOD = 1_000_000_007;

    public int maximumScore(List<Integer> nums, int k) {
        // 1. Get the prime score of each number boundaries
        // 2. Use Monotonic Decreasing Stack to get the left and right
        //    of the largest window that eahc number can be part of
        // 3. Use Max Heap to select the maximum number each time

        int n = nums.size();

        int[] primeScores = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums.get(i), score = 0;

            for (int f = 2; f <= (int) Math.sqrt(num); f++) {
                if (num % f == 0) {
                    score += 1;

                    while (num % f == 0) {
                        num /= f;
                    }
                }
            }

            if (num >= 2) {
                score += 1;
            }

            primeScores[i] = score;
        }

        Stack<Integer> stack = new Stack<>();
        int[] leftBound = new int[n];
        int[] rightBound = new int[n];
        Arrays.fill(leftBound, -1);
        Arrays.fill(rightBound, n);

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && primeScores[stack.peek()] < primeScores[i]) {
                int idx = stack.pop();
                rightBound[idx] = i;
            }

            if (!stack.isEmpty()) {
                leftBound[i] = stack.peek();
            }

            stack.push(i);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            heap.add(new int[] {nums.get(i), i});
        }

        long res = 1;
        while (k > 0) {
            int[] max = heap.poll();
            int num = max[0], idx = max[1];

            int leftCount = idx - leftBound[idx];
            int rightCount = rightBound[idx] - idx;

            long operations = Math.min((long) leftCount * rightCount, (long) k);
            res = (res * power(num, operations)) % MOD;

            k -= operations;
        }

        return (int) res;
    }

    private long power(long base, long exponent) {
        long res = 1;

        // Calculate the exponentiation using binary exponentiation
        while (exponent > 0) {
            // If the exponent is odd, multiply the result by the base
            if (exponent % 2 == 1) {
                res = (res * base) % MOD;
            }

            // Square the base and halve the exponent
            base = (base * base) % MOD;
            exponent /= 2;
        }

        return res;
    }
}
