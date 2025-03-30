package PartitionLabels;

// https://leetcode.com/problems/partition-labels/

import java.util.ArrayList;
import java.util.List;

import static utils.ArrayUtils.printArray;

class Solution {
    // Time: O(n)
    // Space: O(1), because the used array is of size 26 which is constant.
    public List<Integer> partitionLabels(String s) {
        // Store the last occurrence's index of each character in the string.
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Store the result sizes.
        List<Integer> res = new ArrayList<>();

        // Store the end and size of the current split.
        int curEnd = -1;
        int curSize = 0;

        for (int i = 0; i < s.length(); i++) {
            // Increase the size of the current split to consider the current character.
            curSize += 1;

            // Update the current split end to know where exactly we should stop to
            // include all the occurrences of the characters in this split.
            curEnd = Math.max(curEnd, lastIndex[s.charAt(i) - 'a']);

            // If we reached the split end, add the size to the result list, and reset it to 0.
            if (i == curEnd) {
                res.add(curSize);
                curSize = 0;
            }
        }

        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        printArray(sol.partitionLabels("ababcbacadefegdehijhklij"));
        printArray(sol.partitionLabels("eccbbbbdec"));
    }
}