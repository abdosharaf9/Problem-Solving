#include <bits/stdc++.h>
using namespace std;

// https://leetcode.com/problems/valid-anagram/

class Solution {
public:
    
    // Solution #1
    /* bool isAnagram(string s, string t) {
        sort(s.begin(), s.end());
        sort(t.begin(), t.end());
        return s == t;
    } */

    // Solution #2 - more efficient!
    bool isAnagram(string s, string t) {
        int first[26] = {0}, second[26] = {0};
        
        for(auto c : s) first[c - 'a']++;
        for(auto c : t) second[c - 'a']++;

        for (int i = 0; i < 26; i++) {
            if(first[i] != second[i]) return 0;
        }
        
        return 1;
    }
};

int main() {
    Solution sol = Solution();
    cout << sol.isAnagram("anagram", "nagaram") << "\n";
    cout << sol.isAnagram("rat", "car") << "\n";

    return 0;
}