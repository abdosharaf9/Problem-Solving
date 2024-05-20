#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, m, t = 0; char f; cin >> n >> m;
    for(ll i = 0; i < n; i++)
    {
        for(ll j = 0; j < m; j++)
        {
            cin >> f;
            if(f == 'x') t++;
        }
    }
    cout << t;
    return 0;
}
