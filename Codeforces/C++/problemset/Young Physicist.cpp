// Problem Link: https://codeforces.com/problemset/problem/69/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, x, y, z, sum_x = 0, sum_y = 0, sum_z = 0;
    cin >> n;
    for(ll i = 0; i < n; i++)
    {
        cin >> x >> y >> z;
        sum_x += x;
        sum_y += y;
        sum_z += z;
    }
    (sum_x == 0 && sum_y == 0 && sum_z == 0) ? cout << "YES" : cout << "NO";
    return 0;
}
