package MinimumIndexOfAValidSplit;

// https://leetcode.com/problems/minimum-index-of-a-valid-split/

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    // Use the Boyer-Moore Voting algorithm to use constant space.
    // Time: O(n)
    // Space: O(1)
    public int minimumIndex(List<Integer> nums) {
        // Find the majority number in the array using the Boyer-Moore algorithm.
        // Store the majority, and the temporary count.
        int majority = 0, cnt = 0;
        for (int n : nums) {
            // The current number is the new majority number.
            if (cnt == 0) {
                majority = n;
            }

            // Update the temporary count of the majority.
            if (n == majority) {
                cnt += 1;
            } else {
                cnt -= 1;
            }
        }

        // After knowing what the majority number is, we are sure that it will be
        // the number that will be the majority of both portions.

        // Store the frequency of the majority number in the left and right portion.
        // Initially, the left portion is empty and the right portion is the whole array.
        int leftFreq = 0;
        int rightFreq = Collections.frequency(nums, majority);

        // Try to split at each index.
        for (int i = 0; i < nums.size(); i++) {
            // If the current number is the majority, update its frequency in both portions
            // after moving it from the right portion to the left portion.
            int n = nums.get(i);
            if (n == majority) {
                leftFreq += 1;
                rightFreq -= 1;
            }

            // Calculate the length of each portion.
            int leftLen = i + 1;
            int rightLen = nums.size() - i - 1;

            // Check if the current frequencies of the majority in both portions can make a
            // valid portions by checking if its frequency in each portion is at least half
            // of the portion size. This can be converted into:
            // "freq[n] >= size/2" or "2 * freq[n] >= size".
            if (2 * leftFreq > leftLen && 2 * rightFreq > rightLen) {
                // Once we found the first valid index, return it because it will be the minimum we can have.
                return i;
            }
        }

        // We can't split the array.
        return -1;
    }

    // Time: O(n)
    // Space: O(n)
    /*public int minimumIndex(List<Integer> nums) {
        // Store the frequency of the numbers in both the left and right portions.
        // Initially, the left portion is empty and the right portion is the whole array.
        HashMap<Integer, Integer> leftFreq = new HashMap<>();
        HashMap<Integer, Integer> rightFreq = new HashMap<>();
        for (int n : nums) {
            rightFreq.put(n, rightFreq.getOrDefault(n, 0) + 1);
        }

        // Try to split at each index.
        for (int i = 0; i < nums.size(); i++) {
            // Get the current number.
            int n = nums.get(i);

            // Update the frequencies after removing the current number from
            // the right portion and add it to the left portion.
            leftFreq.put(n, leftFreq.getOrDefault(n, 0) + 1);
            rightFreq.put(n, rightFreq.get(n) - 1);

            // Calculate the length of each portion.
            int leftLen = i + 1;
            int rightLen = nums.size() - i - 1;

            // Check if the current number is the majority in both portions, by checking if
            // its frequency in each portion is at least half of the portion size. This can
            // be converted into: "freq[n] >= size/2" or "2 * freq[n] >= size".
            if (2 * leftFreq.get(n) > leftLen && 2 * rightFreq.get(n) > rightLen) {
                // Once we found the first number that is valid, return its index
                // because it will be the minimum we can have.
                return i;
            }
        }

        // We can't split the array.
        return -1;
    }*/
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minimumIndex(List.of(1, 2, 2, 2)));
        System.out.println(sol.minimumIndex(List.of(2, 1, 3, 1, 1, 1, 7, 1, 2, 1)));
        System.out.println(sol.minimumIndex(List.of(3, 3, 3, 3, 7, 2, 2)));
    }
}