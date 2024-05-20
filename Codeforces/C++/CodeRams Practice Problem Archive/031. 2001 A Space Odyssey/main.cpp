#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n; cin >> n;
    for(ll i = 2; i < n/2; i++)
    {
        if(n % i == 0)
        {
            cout << i;
            break;
        }
    }
    return 0;
}
