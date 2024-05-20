// Problem Link: https://codeforces.com/problemset/problem/344/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, g = 1;
    cin >> n;
    ll *m = new ll[n];
    for(ll i = 0; i < n; i++)
    {
        cin >> m[i];
        if(i > 0 && m[i] != m[i-1]) g++;
    }
    cout << g;
    delete []m;
    return 0;
}
