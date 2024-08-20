// https://leetcode.com/problems/score-of-parentheses

class Solution {
public:
    int scoreOfParentheses(string str) {
        stack<int> st;
        st.push(0);

        for(auto c : str) {
            if(c == '(') {
                st.push(0);
            }
            else {
                int last = st.top();
                st.pop();

                if(last == 0) last = 1;
                else last *= 2;

                int new_sum = st.top() + last;
                st.pop();
                st.push(new_sum);
            }
        }

        return st.top();
    }
};