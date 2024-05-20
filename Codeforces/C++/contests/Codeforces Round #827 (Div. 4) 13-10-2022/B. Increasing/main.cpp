#include <bits/stdc++.h>
using namespace std;
#define ll long long

int main()
{
    ll tc, n, x; cin >> tc;
    while(tc--)
    {
        cin >> n;
        set <ll> arr;

        for(ll i = 0; i < n; i++)
        {
            cin >> x;
            arr.insert(x);
        }
        if(arr.size() == n) cout << "YES\n";
        else cout << "NO\n";
    }
    return 0;
}
