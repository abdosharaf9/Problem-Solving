#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll tc; cin >> tc;
    while(tc--)
    {
        ll n; cin >> n;
        ll a[n];
        for(ll i = 0; i < n; i++) cin >> a[i];

        bool f = false;
        for(ll i = 0; i < n-2; i++)
        {
            for(ll j = i+1; j < n-1; j++)
            {
                for(ll k = j+1; k < n; k++)
                {
                    if((a[i] + a[j] + a[k]) % 10 == 3) {cout << "yes\n"; f = true; break;}
                }
                if(f) break;
            }
            if(f) break;
        }
        if(f) continue;
        cout << "no\n";
    }
    return 0;
}
