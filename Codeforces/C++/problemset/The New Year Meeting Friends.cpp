// Problem Link: https://codeforces.com/problemset/problem/723/A

#include <iostream>
#include <algorithm>
using namespace std;
typedef long long ll;
int main()
{
    ll x, y, z;
    cin >> x >> y >> z;
    cout << max(max(x,y), z) - min(min(x,y), z);
    return 0;
}
