#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    string s; cin >> s;
    ll total = 0;

    if(abs(s[0] - 'a') > 13) total += (26 - abs(s[0] - 'a'));
    else total += abs(s[0] - 'a');

    for(ll i = 1; i < s.size(); i++)
    {
        if(abs(s[i] - s[i-1]) > 13) total += (26 - abs(s[i] - s[i-1]));
        else total += abs(s[i] - s[i-1]);
    }
    cout << total;
    return 0;
}
/*
a  --> z
97 --> 122
a       b       c       d       e       f       g       h       i       j       k       l       m       n       o       p       q
97      98      99      100     101     102     103     104     105     106     107     108     109     110     111     112     113
r       s       t       u       v       w       x       y       z
114     115     116     117     118     119     120     121     122

zeus = 18

z --> e
122 - 101 = 21 - 26 = 5
*/
