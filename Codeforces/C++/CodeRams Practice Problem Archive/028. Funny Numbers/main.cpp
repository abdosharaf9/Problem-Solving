#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n; cin >> n; (n % 5 == 0 && n % 7 == 0) ? cout << "YES" : cout << "NO";
    return 0;
}
