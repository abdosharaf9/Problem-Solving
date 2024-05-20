#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main()
{
    ll tc; cin >> tc;
    while(tc--)
    {
        ll x; cin >> x;
        if(x == 3)
        {
            cout << -1 << "\n";
        }
        else if(x % 2 == 0)
        {
            for(ll i = x; i >= 1; i--)
            {
                cout << i << " ";
            }
            cout << "\n";
        }
        else
        {
            ll arr[x];
            ll j = 0;
            for(ll i = x; i >= 1; i--, j++) arr[j] = i;
            for(ll i = 0; i < (x/2); i+=2)
            {
                swap(arr[i], arr[i+1]);
            }
            for(ll i = 0; i < x; i++) cout << arr[i] << " ";
            cout << "\n";
        }
    }

    return 0;
}
