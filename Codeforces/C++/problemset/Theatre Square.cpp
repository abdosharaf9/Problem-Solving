// Problem Link: https://codeforces.com/problemset/problem/1/A

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll n, m, a; cin >> n >> m >> a;
    ll x = n/a, y = m/a;
    if(n%a != 0) x++;
    if(m%a != 0) y++;
    cout << x*y;
    return 0;
}
