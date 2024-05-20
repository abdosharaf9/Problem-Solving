// Problem Link: https://codeforces.com/problemset/problem/116/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n,a,b,c = 0,m = 0;
    cin >> n;
    for(ll i = 0; i < n; i++)
    {
        cin >> a >> b;
        c = (c - a) + b;
        if(c >= m) m = c;
    }
    cout << m;
    return 0;
}
