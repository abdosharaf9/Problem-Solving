package IndexOfTheFirstOccurrenceInString;// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            String curr = haystack.substring(i, i + needle.length());
            if (curr.equals(needle)) return i;
        }

        return -1;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.strStr("sadbutsad", "sad"));
        System.out.println(sol.strStr("leetcode", "leeto"));
    }
}