#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll n, t, k, d; cin >> n >> t >> k >> d;

    //ll times = ceil(n/k);
    ll times = (n + k-1)/k;
    ll oven1 = 0, oven2 = d;

    for(ll i = 0; i < times; i++)
    {
        if(oven1 <= oven2) oven1 += t;
        else oven2 += t;
    }

    if(max(oven1, oven2) < times*t) cout << "YES";
    else cout << "NO";

    return 0;
}
