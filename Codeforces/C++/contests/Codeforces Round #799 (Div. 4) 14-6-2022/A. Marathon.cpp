#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll tc; cin >> tc;
    while(tc--)
    {
        ll a; cin >> a;
        ll x, t = 0;
        for(ll i = 0; i < 3; i++)
        {
            cin >> x;
            if (x > a) t++;
        }
        cout << t << "\n";
    }
    return 0;
}
