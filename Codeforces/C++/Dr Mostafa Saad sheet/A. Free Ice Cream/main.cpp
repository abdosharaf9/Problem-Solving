#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll n, packs, dis = 0, d; cin >> n >> packs;
    char c;

    for(ll i = 0; i < n; i++)
    {
        cin >> c >> d;
        if(c == '+') packs += d;
        else if(d <= packs) packs -= d;
        else dis++;
    }

    cout << packs << " " << dis;
    return 0;
}
