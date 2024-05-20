#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll n, x, pr = 0, ma = 0, pe = 0, ch[3][5000];
    cin >> n;

    for(ll i = 1; i <= n; i++)
    {
        cin >> x;
        if(x == 1)
        {
            ch[0][pr] = i;
            pr++;
        }
        else if(x == 2)
        {
            ch[1][ma] = i;
            ma++;
        }
        else if(x == 3)
        {
            ch[2][pe] = i;
            pe++;
        }
    }

    ll w = min({pr, ma, pe});
    if(w > 0)
    {
        cout << w << "\n";
        for(ll i = 0; i < w; i++)
            cout << ch[0][i] << " " << ch[1][i] << " " << ch[2][i] << "\n";
    }
    else
    {
        cout << 0;
    }
    return 0;
}

/*
7
1 3 1 3 2 1 2

2
3 5 2
6 7 4
*/
