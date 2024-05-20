// Problem Link: https://codeforces.com/problemset/problem/1520/B

//Time limit exceeded !!!!
#include <iostream>
#include <set>
using namespace std;
typedef long long ll;
int main()
{
    ll n, f = 0;
    set <ll> x;
    cin >> n;
    for(ll i = 1; i <= n; i++)
    {
        while(i > 0)
        {
            x.insert(i%10);
            i /= 10;
        }
        if(x.size() == 1) f++;
        x.clear();
    }
    cout << f;
    return 0;
}
