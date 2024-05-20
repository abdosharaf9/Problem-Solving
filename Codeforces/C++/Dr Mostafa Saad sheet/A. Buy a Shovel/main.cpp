#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll k, r; cin >> k >> r;
    for(ll i = 1; i > 0; i++)
    {
        if((i*k)%10 == r || (i*k)%10 == 0)
        {
            cout << i;
            return 0;
        }
    }
    return 0;
}
