#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll tc = 1; cin >> tc;
    while(tc--)
    {
        ll n; cin >> n;
        ll arr[n], moves[n]{};

        for(ll i = 0; i < n; i++) cin >> arr[i];

        for(ll i = 0; i < n; i++)
        {
            ll x; cin >> x;
            char c;
            for(ll j = 0; j < x; j++)
            {
                cin >> c;
                if(c == 'U') moves[i]--;
                else if(c == 'D') moves[i]++;
            }
        }

        for(ll i = 0; i < n; i++)
        {
            cout << (arr[i] + moves[i] + 10) % 10 << " ";
        }
        cout << "\n";
    }

    return 0;
}

/*
Test case #1
3
9 3 1
3 DDD
4 UDUU
2 DU

2 1 1 --> 1 3 7 --> 0 3 1
*/
