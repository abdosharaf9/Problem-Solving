package LargestDivisibleSubset;

// https://leetcode.com/problems/largest-divisible-subset/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// DP solution
// Time: O(n^2)
// Space: O(n)
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Sort the number to easily check the adjacent numbers. In math,
        // if y is divisible by x, and z is divisible by x, then z is
        // divisible by x. We will use this fact to check the numbers.
        Arrays.sort(nums);

        List<List<Integer>> dp = new ArrayList<>();
        for (int num : nums) {
            dp.add(List.of(num));
        }

        // Because we can't guarantee that the first number will give
        // the largest list, we try all the numbers and take the largest.
        List<Integer> res = List.of();

        // Loop over the list in backwards to build the bottom-up solution.
        for (int i = nums.length - 1; i >= 0; i--) {
            // Here we always consider the current number, so each time we
            // calculate the largest list that starts at the current number,
            // and maximize the answer.
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0) {
                    List<Integer> temp = new ArrayList<>(dp.get(j));
                    temp.add(nums[i]);

                    if (temp.size() > dp.get(i).size()) {
                        dp.set(i, temp);
                    }

                }
            }

            // Update the largest list found.
            if (dp.get(i).size() > res.size()) {
                res = dp.get(i);
            }
        }

        return res;
    }
}

// Backtracking with caching
// Time: O(n^2)
// Space: O(n)
/*class Solution {
    HashMap<Integer, List<Integer>> cache = new HashMap<>();

    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Sort the number to easily check the adjacent numbers. In math,
        // if y is divisible by x, and z is divisible by x, then z is
        // divisible by x. We will use this fact to check the numbers.
        Arrays.sort(nums);

        // Because we can't guarantee that the first number will give
        // the largest list, we try all the numbers and take the largest.
        List<Integer> res = List.of();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = backtrack(i, nums);
            if (temp.size() > res.size()) {
                res = temp;
            }
        }

        return res;
    }

    private List<Integer> backtrack(int i, int[] nums) {
        if (i == nums.length) {
            return List.of();
        }

        if (cache.containsKey(i)) {
            return cache.get(i);
        }

        // Here we always consider the current number, so each time we
        // calculate the largest list that starts at the current number,
        // and maximize the answer.
        List<Integer> res = new ArrayList<>();
        res.add(nums[i]);

        // Take the current number with the largest valid list after it, only
        // if it starts with a number that is divisible by the current number.
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] % nums[i] == 0) {
                List<Integer> temp = new ArrayList<>(backtrack(j, nums));
                temp.add(nums[i]);

                if (temp.size() > res.size()) {
                    res = temp;
                }
            }
        }

        cache.put(i, res);
        return res;
    }
}*/

// Backtracking with caching, but gives TLE
// Time: O(n^2)
// Space: O(n^2)
/*class Solution {
    // Store the result for each state.
    private final HashMap<int[], List<Integer>> cache = new HashMap<>();

    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Sort the number to easily check the adjacent numbers. In math,
        // if y is divisible by x, and z is divisible by x, then z is
        // divisible by x. We will use this fact to check the numbers.
        Arrays.sort(nums);

        // The previous initially can be 1, because it's a divisor of all number.
        return backtrack(0, 1, nums);
    }

    private List<Integer> backtrack(int i, int prev, int[] nums) {
        if (i == nums.length) {
            return List.of();
        }

        if (cache.containsKey(new int[]{i, prev})) {
            return cache.get(new int[]{i, prev});
        }

        // Skip the current number.
        List<Integer> res = backtrack(i + 1, prev, nums);

        // Consider the current number, only if it is divisible by the previous.
        if (nums[i] % prev == 0) {
            // The current number's list will be the next number's list and the current number.
            List<Integer> temp = new ArrayList<>(backtrack(i + 1, nums[i], nums));
            temp.add(nums[i]);

            // Take the largest list.
            if (temp.size() > res.size()) {
                res = temp;
            }
        }

        cache.put(new int[]{i, prev}, res);
        return res;
    }
}*/

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(sol.largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }
}