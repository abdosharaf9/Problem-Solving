#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll a, b; cin >> a >> b;
    if(a == b) cout << "Yes";
    else if ((a + b) % 2 == 0) cout << "Yes";
    else cout << "No";
    return 0;
}
