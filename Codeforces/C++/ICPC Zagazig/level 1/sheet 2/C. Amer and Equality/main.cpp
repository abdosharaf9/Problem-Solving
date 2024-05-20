#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll x, s = 0; cin >> x;
    for(ll i = 1; i <= x; i++)
    {
        for(ll j = 1; j <= x; j++) if(i + j == x) s++;
    }
    if(s%2 == 0) cout << s/2;
    else cout << s/2+1;
    return 0;
}
