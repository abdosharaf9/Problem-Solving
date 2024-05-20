// Problem Link: https://codeforces.com/problemset/problem/37/A

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll n, x; cin >> n;
    ll arr[1001]{};
    while(n--)
    {
        cin >> x; arr[x]++;
    }

    cout << *max_element(arr, arr+1001) << " ";

    ll t = 0;
    for(ll i = 0; i < 1001; i++)
        if(arr[i] > 0) t++;

    cout << t;
    return 0;
}
