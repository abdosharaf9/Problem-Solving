package ShortestPalindrome;

// https://leetcode.com/problems/shortest-palindrome/

class Solution {
    public String shortestPalindrome(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (isPalindrome(s, 0, i)) {
                StringBuilder suffix = new StringBuilder(s.substring(i + 1));
                suffix.reverse();
                return suffix + s;
            }
        }

        return "";
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        print(sol.shortestPalindrome("aacecaaa"));
        print(sol.shortestPalindrome("abcd"));
        print(sol.shortestPalindrome(""));
        print(sol.shortestPalindrome("abbacd"));
    }

    private static void print(String s) {
        System.out.println("\"" + s + "\"");
    }
}