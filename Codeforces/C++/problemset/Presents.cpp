// Problem Link: https://codeforces.com/problemset/problem/136/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, b;
    cin >> n;
    ll *p = new ll[n];
    for(ll i = 0; i < n; i++)
    {
        cin >> b;
        p[b-1] = i+1;
    }
    for(ll i = 0; i < n; i++)
        cout << p[i] << " ";
    delete [] p;
    return 0;
}
