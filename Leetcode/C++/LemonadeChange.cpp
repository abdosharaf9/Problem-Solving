#include <bits/stdc++.h>
using namespace std;

// https://leetcode.com/problems/lemonade-change/

class Solution {
public:
    bool lemonadeChange(vector<int> &bills) {
        int fives = 0, tens = 0;

        for (auto x : bills) {
            if (x == 5)fives++;
            else if (x == 10) tens++;

            int change = x - 5;

            // Not very efficient!
            /* if(change == 5) {
                if(fives) fives--;
                else return 0;
            } else if(change == 15) {
                if(tens && fives) tens--, fives--;
                else if(fives >= 3) fives -= 3;
                else return 0;
            } */

            while (tens && change > 5) {
                tens--;
                change -= 10;
            }

            while (fives && change > 0) {
                fives--;
                change -= 5;
            }

            if (change != 0) return 0;
        }

        return 1;
    }
};

int main() {
    Solution test = Solution();

    vector<int> v({5, 5, 5, 10, 20});
    cout << test.lemonadeChange(v) << "\n";

    v = {5, 5, 10, 10, 20};
    cout << test.lemonadeChange(v);

    return 0;
}