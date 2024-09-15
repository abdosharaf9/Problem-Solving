package LongestSubstringContainingVowelsInEvenCounts;

// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/

import java.util.HashMap;

class Solution {
    public int findTheLongestSubstring(String s) {
        int res = 0;
        int mask = 0;
        String vowels = "aeiou";
        HashMap<Integer, Integer> maskToIndex = new HashMap<>();
        maskToIndex.put(0, -1);

        for (int i = 0; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) != -1)
                mask = mask ^ ((int) s.charAt(i) - (int) 'a' + 1);

            if (maskToIndex.get(mask) != null) {
                int length = i - maskToIndex.get(mask);
                res = Math.max(res, length);
            } else {
                maskToIndex.put(mask, i);
            }
        }

        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findTheLongestSubstring("eleetminicoworoep"));
        System.out.println(sol.findTheLongestSubstring("leetcodeisgreat"));
        System.out.println(sol.findTheLongestSubstring("bcbcbc"));
    }
}
