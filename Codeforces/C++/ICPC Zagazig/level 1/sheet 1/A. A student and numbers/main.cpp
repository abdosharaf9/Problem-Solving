#include <iostream>
using namespace std;
typedef long long ll;
char compare(ll x, ll y)
{
    char o;
    if(x > y) o = '>';
    else if(x < y) o = '<';
    else o = '=';
    return o;
}
int main()
{
    ll x, y; cin >> x >> y; cout << compare(x, y);
    return 0;
}
