// Problem Link: https://codeforces.com/problemset/problem/443/A

#include <iostream>
#include<bits/stdc++.h>
#include <string>
using namespace std;
int main()
{
    string s;
    getline(cin, s);
    set <char> x;
    for(long long i = 0; i < s.size(); i++)
        if(s[i] >= 'a' && s[i] <= 'z') x.insert(s[i]);

    cout << x.size();
    return 0;
}
