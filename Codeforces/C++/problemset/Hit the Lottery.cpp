// Problem Link: https://codeforces.com/problemset/problem/996/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, x = 0;
    cin >> n;
    x += n/100;
    n = n%100;
    x += n/20;
    n = n%20;
    x += n/10;
    n = n%10;
    x += n/5;
    n = n%5;
    x += n;
    cout << x;
    return 0;
}
