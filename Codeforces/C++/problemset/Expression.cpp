#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll a, b, c, e1, e2, e3, e4;
    cin >> a >> b >> c;
    e1 = a + b + c;
    e2 = (a + b) * c;
    e3 = a * (b + c);
    e4 = a * b * c;
    cout << max(e1, max(e2, max(e3, e4)));
    return 0;
}
