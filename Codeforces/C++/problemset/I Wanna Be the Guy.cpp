// Problem Link: https://codeforces.com/problemset/problem/469/A

#include <iostream>
#include <set>
using namespace std;
typedef long long ll;
int main()
{
    ll n,p,q,a;
    set <ll> all;
    cin >> n;
    cin >> p;
    for(ll i = 0; i < p; i++)
    {
        cin >> a;
        all.insert(a);
    }
    cin >> q;
    for(ll i = 0; i < q; i++)
    {
        cin >> a;
        all.insert(a);
    }
    (all.size() == n) ? cout << "I become the guy." : cout << "Oh, my keyboard!";
    return 0;
}
