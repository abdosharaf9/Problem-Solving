#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll n; cin >> n;
    ll arr[n], mn, mx;

    for(ll i = 0; i < n; i++)
        cin >> arr[i];

    for(ll i = 0; i < n; i++)
    {
        mx = max(abs(arr[i] - arr[0]), abs(arr[i] - arr[n-1]));
        if(i == 0)
        {
            cout << abs(arr[i] - arr[1]) << " " << mx << "\n";
        }
        else if(i == n-1)
        {
            cout << abs(arr[i] - arr[n-2]) << " " << mx << "\n";
        }
        else
        {
            mn = min(abs(arr[i] - arr[i-1]), abs(arr[i] - arr[i+1]));
            cout << mn << " " << mx << "\n";
        }
    }

    return 0;
}

/*
4
-5 -2 2 7

3 12
3 9
4 7
5 12
*/
