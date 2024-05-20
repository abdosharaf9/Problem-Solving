#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll tc; cin >> tc;
    while(tc--)
    {
        ll a, b, c; cin >> a >> b >> c;
        if(a == 1) cout << 1 << "\n";
        else if(abs(b - c) + (c - 1) < a - 1) cout << 2 << "\n";
        else if(abs(b - c) + (c - 1) > a - 1) cout << 1 << "\n";
        else cout << 3 << "\n";
    }


    return 0;
}
