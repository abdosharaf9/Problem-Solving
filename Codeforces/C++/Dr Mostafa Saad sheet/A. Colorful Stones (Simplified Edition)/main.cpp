#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    string s, t; cin >> s >> t;
    ll i = 0, pos = 1;

    for(ll j = 0; j < t.size(); j++)
    {
        if(s[i] == t[j])
        {
            pos++;
            i++;
        }
    }
    cout << pos;
    return 0;
}
