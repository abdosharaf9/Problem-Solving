// Problem Link: https://codeforces.com/problemset/problem/200/B

#include <iostream>
#include <iomanip>
using namespace std;
typedef long long ll;
int main()
{
    ll n, d;
    double sum = 0;
    cin >> n;
    for(ll i = 0; i< n; i++)
    {
        cin >> d;
        sum+= d;
    }
    cout << fixed << setprecision(12) << sum/n;
    return 0;
}
