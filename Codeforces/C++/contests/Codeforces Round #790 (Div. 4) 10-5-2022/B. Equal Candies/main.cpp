#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll t; cin >> t;
    while(t--)
    {
        ll n; cin >> n;
        ll a[n];

        for(ll i = 0; i < n; i++)
            cin >> a[i];
        sort(a, a+n);
        ll sum = 0;

        for(ll i = 1; i < n; i++)
            sum += a[i] - a[0];

        cout << sum << "\n";
    }
    return 0;
}
