#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll tc; cin >> tc;
    while(tc--)
    {
        ll n; cin >> n;
        ll arr[n];

        for(ll i = 0; i < n; i++) cin >> arr[i];

        sort(arr, arr+n);
        ll x = arr[0], y = arr[1], z = arr[2];

        ll mn, mx;
        mn = (z-x)+(z-y);
        mx = ((z-x)+x)+ ((z-y)+y);

        cout << min(mn, mx) << "\n";
    }

    return 0;
}
