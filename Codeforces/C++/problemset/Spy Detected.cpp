// Problem Link: https://codeforces.com/problemset/problem/1512/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, t;
    cin >> t;
    for(ll j = 0; j < t; j++)
    {
        cin >> n;
        ll *a = new ll[n];
        for(ll i = 0; i < n; i++)
            cin >> a[i];
        for(ll i = 0; i < n; i++)
        {
            if(i == 0 && a[i] != a[i+1] && a[i] != a[i+2])
            {
                cout << i+1 << "\n";
                delete [] a;
                break;
            }
            else if(i > 0 && a[i] != a[i-1] && a[i] != a[i+1])
            {
                cout << i+1 << "\n";
                delete [] a;
                break;
            }
        }
    }
    return 0;
}
