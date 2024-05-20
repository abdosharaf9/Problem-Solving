#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll tc = 1; cin >> tc;
    while(tc--)
    {
        ll n; cin >> n;
        if(log10(n) == ll(log10(n))) cout << 0 << "\n";
        else cout << fixed << ll(n - pow(10, ll(log10(n)))) << "\n";
    }

    return 0;
}
