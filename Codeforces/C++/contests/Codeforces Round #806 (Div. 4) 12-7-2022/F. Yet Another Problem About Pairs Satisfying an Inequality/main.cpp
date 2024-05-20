#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll pre[200001];

int main()
{
    ll tc; cin >> tc;
    while(tc--)
    {
        ll n; cin >> n;
        ll arr[200001];

        for(ll i = 0; i < n; i++)
        {
            cin >> arr[i];
            arr[i]--;
            pre[i+1] = pre[i] + (arr[i] < i);
        }

        ll res = 0;
        for(ll i = 0; i < n; i++)
        {
            if(arr[i] < i and arr[i] >= 0) res += pre[arr[i]];
        }
        cout << res << "\n";
    }

    return 0;
}
