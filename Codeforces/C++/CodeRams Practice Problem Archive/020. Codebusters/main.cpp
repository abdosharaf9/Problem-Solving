#include <iostream>
#include <string>
using namespace std;
typedef long long ll;
int main()
{
    ll n; string s; cin >> n;
    for(ll i = 0; i < n; i++)
    {
        cin >> s;
        if(s.size() % 2 == 0)
        {
            for(ll j = 0; j < s.size(); j+= 2)
            {
                swap(s[j], s[j+1]);
            }
        }
        else
        {
            for(ll j = 0; j < s.size()-1; j+= 2)
            {
                swap(s[j], s[j+1]);
            }
        }
        cout << s << "\n";
    }
    return 0;
}
