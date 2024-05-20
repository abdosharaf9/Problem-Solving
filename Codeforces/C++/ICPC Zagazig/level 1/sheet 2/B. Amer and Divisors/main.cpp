#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll x; cin >> x; for(ll i = 1; i <= x; i++) if(x%i == 0) cout << i << " ";
    return 0;
}
