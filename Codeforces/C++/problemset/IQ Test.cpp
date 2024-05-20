// Problem Link: https://codeforces.com/problemset/problem/25/A

#include <iostream>
typedef long long ll;
using namespace std;
int main()
{
    ll n, ev = 0, od = 0; cin >> n;
    ll *a = new ll[n];
    for(ll i = 0; i < n; i++)
    {
        cin >> a[i];
        (a[i]%2 == 0) ? ev++ : od++;
    }
    if(ev == (n-1))
    {
        for(ll i = 0; i < n; i++)
        {
            if(a[i]%2 != 0)
            {
                cout << i+1;
                delete [] a;
                return 0;
            }
        }
    }
    else
    {
        for(ll i = 0; i < n; i++)
        {
            if(a[i]%2 == 0)
            {
                cout << i+1;
                delete [] a;
                return 0;
            }
        }
    }
}
