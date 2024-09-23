#include<bits/stdc++.h>
using namespace std;

// https://leetcode.com/problems/extra-characters-in-a-string/

class Solution {
public:
    int memo[51];

    int solve(int idx, string& s, vector<string>& dictionary) {
        if(idx >= s.size()) return 0;
        if(memo[idx] != -1) return memo[idx];

        int op1 = solve(idx + 1, s, dictionary) + 1;
        int op2 = INT_MAX;

        for(string word : dictionary) {
            if(s.find(word, idx) == idx) {
                op2 = min(op2, solve(idx + word.size(), s, dictionary));
            }
        }
        memo[idx] = min(op1, op2);

        return memo[idx];
    }

    int minExtraChar(string s, vector<string>& dictionary) {
        memset(memo, -1, sizeof memo);
        return solve(0, s, dictionary);
    }
};

int main() {
    Solution sol = Solution();
    vector<string> v;
    string s;

    s = "leetscode";
    v = {"leet","code","leetcode"};
    cout << sol.minExtraChar(s, v) << "\n";

    s = "sayhelloworld";
    v = {"hello","world"};
    cout << sol.minExtraChar(s, v) << "\n";

    return 0;
}