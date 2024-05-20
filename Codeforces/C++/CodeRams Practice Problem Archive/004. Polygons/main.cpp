#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll t, s; cin >> t;
    for(ll i = 0; i < t; i++)
    {
        ll f = 180;
        cin >> s;
        while(s > 3){f += 180; s--;}
        cout << f << "\n";
    }
    return 0;
}
