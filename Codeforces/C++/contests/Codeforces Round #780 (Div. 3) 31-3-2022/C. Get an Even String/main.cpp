#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll t; cin >> t;
    while(t--)
    {
        string s; cin >> s;
        ll let[26] = {0};
        for(ll i = 0; i < s.size(); i++)
            let[s[i]-97]++;
        ll res = 0;

        for(ll i = 0; i < 26; i++)
        {
            res += (let[i] - *min_element(let, let+26));
        }

        cout << res << "\n";
    }
    return 0;
}
