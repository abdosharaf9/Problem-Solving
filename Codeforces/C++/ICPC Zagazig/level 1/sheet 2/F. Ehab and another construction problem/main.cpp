#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll x; cin >> x;
    for(ll i = 1; i <= x; i++)
    {
        for(ll j = 1; j <= x; j++)
        {
            if(i%j == 0 && i*j > x && i/j < x)
            {
                cout << i << " " << j;
                return 0;
            }
        }
    }
    cout << -1;
    /*
    OR:-
    if(x == 1) cout << -1;
    else cout << x << " " << x;
    */
    return 0;
}
