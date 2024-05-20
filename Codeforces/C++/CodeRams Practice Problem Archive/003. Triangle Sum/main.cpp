#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, s = 0, t; cin >> n;
    for(ll i = 0; i < n; i++){cin >> t; s += t*3;}
    cout << s;
    return 0;
}
