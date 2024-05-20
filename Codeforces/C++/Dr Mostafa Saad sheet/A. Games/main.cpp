#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll n, t = 0; cin >> n;
    ll home[n], guest[n];
    for(ll i = 0; i < n; i++)
        cin >> home[i] >> guest[i];

    for(ll i = 0; i < n; i++)
    {
        for(ll j = 0; j < n; j++)
        {
            if(home[i] == guest[j])
                t++;
        }
    }
    cout << t;
    return 0;
}
