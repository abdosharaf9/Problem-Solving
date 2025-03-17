package DivideArrayIntoEqualPairs;

// https://leetcode.com/problems/divide-array-into-equal-pairs/

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    // Time: O(n)
    // Space: O(n), technically the used array have a fixed size, so we can consider it a kind of O(1).
    public boolean divideArray(int[] nums) {
        // Store true if the number needs a pair, and false otherwise.
        boolean[] needPair = new boolean[501];
        for (int n : nums) {
            // Flip the current number's value.
            needPair[n] = !needPair[n];
        }

        for (int n : nums) {
            // If the current number needs a pair, return false.
            if (needPair[n]) {
                return false;
            }
        }

        // All the numbers can form pairs.
        return true;
    }

    // Time: O(n)
    // Space: O(n)
    /*public boolean divideArray(int[] nums) {
        // Store the numbers with no pairs.
        HashSet<Integer> unpaired = new HashSet<>();

        for (int n : nums) {
            // If the current number has a previous number to form a pair with it,
            // remove it from the set. If it can't form a pair, add it to the set.
            if (unpaired.contains(n)) {
                unpaired.remove(n);
            } else {
                unpaired.add(n);
            }
        }

        // Check if all the numbers can form pairs.
        return unpaired.isEmpty();
    }*/

    // Time: O(n)
    // Space: O(n)
    /*public boolean divideArray(int[] nums) {
        // Store the frequency of each number.
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int n : nums) {
            mp.put(n, mp.getOrDefault(n, 0) + 1);
        }

        // Check if all the frequencies are even.
        for (int v : mp.values()) {
            if (v % 2 != 0) {
                return false;
            }
        }

        // All the numbers appear even number of times in the array.
        return true;
    }*/

    // Time: O(n * log n)
    // Space: O(1)
    /*public boolean divideArray(int[] nums) {
        // Sort the nums in ascending order.
        Arrays.sort(nums);

        // Loop over all the adjacent numbers, and check if they aren't equal.
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }

        // All the numbers appear even number of times in the array.
        return true;
    }*/
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.divideArray(new int[]{3, 2, 3, 2, 2, 2}));
        System.out.println(sol.divideArray(new int[]{1, 2, 3, 4}));
    }
}