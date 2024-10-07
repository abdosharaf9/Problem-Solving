package MinimumStringLengthAfterRemovingSubstrings;

import java.util.Stack;

class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (st.empty()) {
                st.push(c);
            } else if ((c == 'B' && st.peek() == 'A') || (c == 'D' && st.peek() == 'C')) {
                st.pop();
            } else {
                st.push(c);
            }
        }

        return st.size();
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minLength("ABFCACDB"));
        System.out.println(sol.minLength("ACBBD"));
        System.out.println(sol.minLength("D"));
    }
}