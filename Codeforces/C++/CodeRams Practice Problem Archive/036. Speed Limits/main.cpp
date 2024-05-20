#include <iostream>
#include <string>
using namespace std;
typedef long long ll;
int main()
{
    ll s = 0; cin >> s;
    string dbname[s]; ll dbspeed[s];
    for(ll i = 0; i < s; i++)
    {
        cin >> dbname[i] >> dbspeed[i];
    }
    ll t; string T; cin >> t;
    for(ll i = 0; i < t; i++)
    {
        cin >> T;
        for(ll j = 0; j < s; j++)
        {
            if(T == dbname[j])
            {
                cout << dbspeed[j] << "\n";
                break;
            }
        }
    }
    return 0;
}
