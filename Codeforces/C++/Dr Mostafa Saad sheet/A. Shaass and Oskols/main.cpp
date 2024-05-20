#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll n; cin >> n;
    ll wires[n];
    for(ll i = 0; i < n; i++)
        cin >> wires[i];

    ll m, x, y, r, l; cin >> m;
    for(ll i = 0; i < m; i++)
    {
        cin >> x >> y;
        r = wires[x-1] - y; l = wires[x-1] - r - 1;
        wires[x-1] = 0;
        if(x == 1)
        {
            wires[1] += r;
        }
        else if(x == n)
        {
            wires[x-2] += l;
        }
        else
        {
            wires[x-2] += l;
            wires[x] += r;
        }
    }

    for(ll i = 0; i < n; i++)
        cout << wires[i] << "\n";
    return 0;
}
/*
x --> 1 based
left --> up x-2
right --> down x
*/
