#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, m, sum = 0; cin >> n;
    for(ll i = 0; i < n; i++)
    {
        cin >> m;
        sum += m;
    }
    cout << sum;
    return 0;
}
