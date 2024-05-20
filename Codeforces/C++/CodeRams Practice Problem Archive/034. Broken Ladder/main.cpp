#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, k, rnew, rold; cin >> n >> k;
    for(ll i = 0; i < n; i++)
    {
        cin >> rnew;
        if(i == 0) rold = rnew;
        if((rnew - rold) > k)
        {
            cout << "NO";
            return 0;
        }
        rold = rnew;
    }
    cout << "YES";
    return 0;
}
