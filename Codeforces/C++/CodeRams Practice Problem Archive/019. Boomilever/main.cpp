#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, m, b, t = 0; cin >> n >> m;
    for(ll i = 0; i < n; i++)
    {
        cin >> b;
        if(b >= m) t++;
    }
    cout << t;
    return 0;
}
