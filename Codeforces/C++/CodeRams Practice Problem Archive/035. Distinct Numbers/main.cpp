#include <iostream>
#include <set>
using namespace std;
typedef long long ll;
int main()
{
    ll n, x; set <ll> t; cin >> n;
    for(ll i = 0; i < n; i++)
    {
        cin >> x;
        t.insert(x);
    }
    cout << t.size();
    return 0;
}
