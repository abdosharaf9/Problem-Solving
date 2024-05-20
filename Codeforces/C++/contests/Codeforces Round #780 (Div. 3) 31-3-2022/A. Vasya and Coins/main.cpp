#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll t; cin >> t;
    while(t--)
    {
        ll a, b; cin >> a >> b;

        if(a == 0)
            cout << 1 << "\n";
        else
            cout << a + (b*2) + 1 << "\n";
    }
    return 0;
}
