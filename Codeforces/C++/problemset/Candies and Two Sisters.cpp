// Problem Link: https://codeforces.com/problemset/problem/1335/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll t, n, w;
    cin >> t;
    for(ll i = 0; i < t; i++)
    {
        cin >> n;
        w = 0;
        if(n < 3) cout << w << "\n";
        else
        {
            if(n%2 == 0) w = (n/2)-1;
            else w = n/2;
            cout << w << "\n";
        }
    }
    return 0;
}

/*#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll t, n, w;
    cin >> t;
    for(ll i = 0; i < t; i++)
    {
        cin >> n;
        w = 0;
        if(n < 3) cout << w << "\n";
        else
        {
            for(ll x = 1; x <= n; x++)
            {
                for(ll y = 1; y < x; y++)
                    if(n-x-y == 0 && x > y) w++;
            }
            cout << w << "\n";
        }
    }
    return 0;
}
*/
