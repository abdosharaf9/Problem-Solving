// Problem Link: https://codeforces.com/problemset/problem/266/B

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n,t;
    cin >> n >> t;
    char *q = new char[n];
    for(ll i = 0; i < n; i++)
        cin >> q[i];
    for(ll i = 0; i < t; i++)
    {
        for(ll j = 0; j < n-1; j++)
        {
            if(q[j] == 'B'&& q[j+1] == 'G')
            {
                swap(q[j],q[j+1]);
                j++;
            }
        }
    }
    for(ll i = 0; i < n; i++)
        cout << q[i];

    delete [] q;
    return 0;
}
