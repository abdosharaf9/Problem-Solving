// https://leetcode.com/problems/valid-parentheses

#include<iostream>
#include<stack>
using namespace std;

bool isValid(string s) {
    stack<char> st;

    for(auto c : s) {
        if(c == '(' || c == '{' || c == '[') st.push(c);
        else {
            if(st.empty()) return false;
            else if(c == ')' && st.top() != '(') return false;
            else if(c == '}' && st.top() != '{') return false;
            else if(c == ']' && st.top() != '[') return false;
            else st.pop();
        }
    }

    return st.empty();
}

int main() {

    cout << isValid("]") << "\n";
    cout << isValid("()") << "\n";
    cout << isValid("()[]{}") << "\n";
    cout << isValid("(]") << "\n";
    cout << isValid("([])") << "\n";

    return 0;
}