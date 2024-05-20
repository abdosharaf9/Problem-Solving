#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll x; cin >> x;
    while(x%10 == 0){x/=10;}
    while(x > 0)
    {
        cout << x%10;
        x /= 10;
    }
    return 0;
}
