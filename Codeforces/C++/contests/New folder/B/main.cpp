#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll tc=1; cin >> tc;
    while(tc--)
    {
        ll n, x; cin >> n;
        string s, t = ""; cin >> s;


        for(ll i = n-1; i >= 0; i--)
        {
            if(s[i] == '0')
            {
                x = (s[i-1] - '0') + ((s[i-2] - '0') * 10);
                t += char(x + 96);
                i -=2 ;
            }
            else
            {
                x = s[i] - '0';
                t += char(x + 96);
            }
        }

        reverse(t.begin(), t.end());
        cout << t << "\n";
    }

    return 0;
}
