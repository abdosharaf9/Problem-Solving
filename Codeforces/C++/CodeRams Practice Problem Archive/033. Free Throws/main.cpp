#include <iostream>
#include <iomanip>
using namespace std;
typedef long long ll;
int main()
{
    ll n, t, ta; double tsum = 0, tasum = 0; cin >> n;
    for(ll i = 0; i < n; i++)
    {
        cin >> t >> ta;
        tsum += t; tasum += ta;
    }
    cout << fixed << setprecision(2) << (tsum / tasum) * 100;
    return 0;
}
