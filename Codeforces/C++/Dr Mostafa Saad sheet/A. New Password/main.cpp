#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    string s1 = "abcdefghijklmnopqrstuvwxyz", s2 = "";
    ll n, k; cin >> n >> k;

    for(ll i = 0; i < n; i++)
        s2 += s1[i % k];

    cout << s2;
    return 0;
}
