#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll tc; cin >> tc;
    while(tc--)
    {
        ll n, x; cin >> n;
        set <ll> a;
        
        for(ll i = 0; i < n; i++)
        {
            cin >> x;
            a.insert(x);
        }
        if((n - a.size()) % 2 == 0) cout << a.size() << "\n";
        else cout << a.size()-1 << "\n";
    }
    return 0;
}
