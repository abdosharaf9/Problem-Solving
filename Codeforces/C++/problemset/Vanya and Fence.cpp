// Problem Link: https://codeforces.com/problemset/problem/677/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n,h,a,r = 0;
    cin >> n >> h;
    for(ll i = 0; i < n; i++)
    {
        cin >> a;
        if(a <= h) r++;
        else r+=2;
    }
    cout << r;
    return 0;
}
