#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll tc; cin >> tc;
    while(tc--)
    {
        ll n, t = 0; cin >> n;
        bool vis[26]{};
        string s; cin >> s;

        for(ll i = 0; i < n; i++)
        {
            if(vis[s[i] - 'A']) t++;
            else {t+=2; vis[s[i]-'A'] = 1;}
        }
        cout << t << "\n";
    }

    return 0;
}
