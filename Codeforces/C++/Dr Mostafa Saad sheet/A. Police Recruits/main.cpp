#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, e, c = 0, p = 0; cin >> n;
    for(ll i = 0; i < n; i++)
    {
        cin >> e;
        if(e > 0) p += e;
        else
        {
            if(p > 0)
                p--;
            else
                c++;
        }
    }
    cout << c;
    return 0;
}
