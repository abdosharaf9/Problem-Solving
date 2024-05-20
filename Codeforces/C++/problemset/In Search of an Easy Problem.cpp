// Problem Link: https://codeforces.com/problemset/problem/1030/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n,p,g = 0;
    cin >> n;
    for(ll i = 0; i < n; i++)
    {
        cin >> p;
        if(p == 1) g++;
    }
    (g == 0) ? cout << "EASY" : cout << "HARD";
    return 0;
}
