#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll tc = 1; cin >> tc;
    while(tc--)
    {
        ll n; cin >> n;
        char arr[n][n];

        for(ll i = 0; i < n; i++)
        {
            for(ll j = 0; j < n; j++)
                cin >> arr[i][j];
        }

        ll res = 0;
        for(ll i = 0; i < n/2; i++)
        {
            for(ll j = i; j < n-i-1; j++)
            {
                ll t = 0;
                t += (arr[i][j] - '0');
                t += (arr[j][n-i-1] - '0');
                t += (arr[n-j-1][i] - '0');
                t += (arr[n-i-1][n-j-1] - '0');
                res += min(t, 4 - t);
            }
        }
        cout << res << "\n";
    }

    return 0;
}
