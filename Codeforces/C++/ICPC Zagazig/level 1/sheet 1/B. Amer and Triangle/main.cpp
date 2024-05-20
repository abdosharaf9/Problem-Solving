#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll a, b, c; cin >> a >> b >> c;
    a *= a; b *= b; c *= c;
    ((a == b + c) || (b == a + c) || (c == a + b))? cout << "yes" : cout << "no";
    return 0;
}

/*#include <iostream>
#include <math.h>
using namespace std;
typedef long long ll;
bool rt(ll x, ll y, ll z)
{
    if(x >= y && x >= z)
    {
        if(pow(x, 2) == (pow(y, 2) + pow(z, 2))) return true;
        else return false;
    }
    else if(y >= x && y >= z)
    {
        if(pow(y, 2) == (pow(x, 2) + pow(z, 2))) return true;
        else return false;
    }
    else
    {
        if(pow(z, 2) == (pow(x, 2) + pow(y, 2))) return true;
        else return false;
    }
}
int main()
{
    ll a, b, c; cin >> a >> b >> c; cout << rt(a, b, c);
    return 0;
}
*/
