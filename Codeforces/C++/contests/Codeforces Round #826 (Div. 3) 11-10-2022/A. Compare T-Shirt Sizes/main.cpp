#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

ll calc(string s)
{
    ll res = 1;
    if(s.size() != 1)
    {
        for(ll i = 0; i < s.size(); i++)
        {
            if(s[i] == 'S') {res++; res*=-1;}
            else res++;
        }
    }
    else
    {
        if(s[0] == 'S') res = -1;
        else if(s[0] == 'M') res = 0;
        else res = 1;
    }

    return res;
}

int main()
{
    ll tc; cin >> tc;
    while(tc--)
    {
        string s1, s2; cin >> s1 >> s2;
        ll x1 = calc(s1), x2 = calc(s2);

        if(x1 > x2) cout << ">\n";
        else if(x2 > x1) cout << "<\n";
        else cout << "=\n";

    }


    return 0;
}
