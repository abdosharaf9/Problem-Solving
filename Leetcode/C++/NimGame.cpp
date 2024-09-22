#include<bits/stdc++.h>
using namespace std;

// https://leetcode.com/problems/nim-game/

class Solution {
public:
    bool canWinNim(int n) {
        return n % 4;
    }
};

int main() {
    Solution sol = Solution();
    cout << sol.canWinNim(4) << "\n";
    cout << sol.canWinNim(1) << "\n";
    cout << sol.canWinNim(2) << "\n";

    return 0;
}