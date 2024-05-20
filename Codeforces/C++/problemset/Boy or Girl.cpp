// Problem Link: https://codeforces.com/problemset/problem/236/A

#include <iostream>
#include <set>
#include <string>
using namespace std;
int main()
{
    string s;
    cin >> s;
    set <char> lt;
    for(long long i = 0; i < s.size(); i++)
        lt.insert(s[i]);
    ((lt.size()%2) == 0) ? cout << "CHAT WITH HER!" : cout << "IGNORE HIM!";
    return 0;
}
