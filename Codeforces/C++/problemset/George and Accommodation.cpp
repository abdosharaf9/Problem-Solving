// Problem Link: https://codeforces.com/problemset/problem/467/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, p, q, r = 0;
    cin >> n;
    for(ll i = 0; i < n; i++)
    {
        cin >> p >> q;
        if(p < q && (q-p) >= 2) r++;
    }
    cout << r;
    return 0;
}
