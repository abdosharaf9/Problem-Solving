// Problem Link: https://codeforces.com/problemset/problem/758/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, sum = 0, max = 0;
    cin >> n;
    ll *x = new ll[n];
    for(ll i = 0; i < n; i++)
    {
        cin >> x[i];
        if(x[i] > max) max = x[i];
    }
    for(ll i = 0; i < n; i++)
        sum += (max-x[i]);
    cout << sum;
    delete []x;
    return 0;
}
