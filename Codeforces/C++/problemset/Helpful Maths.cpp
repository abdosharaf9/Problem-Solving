// Problem Link: https://codeforces.com/problemset/problem/339/A

#include <iostream>
#include <string>
using namespace std;
typedef long long ll;
int main()
{
    string s, r = "";
    cin >> s;

    for(ll i = 0; i < s.size(); i++)
    {
        if(s[i] != '+') r+=s[i];
    }

    for(ll i = 0; i < r.size()-1; i++)
    {
        for(ll j = 0; j < r.size()-i-1; j++)
        {
            if(r[j] > r[j+1]) swap(r[j], r[j+1]);
        }
    }

    for(ll i = 0; i < r.size(); i++)
    {
        if(i == r.size()-1) cout << r[i];
        else cout << r[i] << '+';
    }

    return 0;
}
