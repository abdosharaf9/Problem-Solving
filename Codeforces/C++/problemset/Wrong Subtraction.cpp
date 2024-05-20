// Problem Link: https://codeforces.com/problemset/problem/977/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n,k;
    cin >> n >> k;
    for(ll i = 0; i < k; i++)
    {
        if((n%10) > 0) n -= 1;
        else if((n%10) == 0) n /= 10;
    }
    cout << n;
    return 0;
}
