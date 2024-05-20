// Problem Link: https://codeforces.com/problemset/problem/520/A

#include <iostream>
#include <set>
using namespace std;
typedef long long ll;
int main()
{
    ll n = 0;
    cin >> n;
    char w[n];
    set <char> lt;
    for(ll i = 0; i < n; i++)
    {
        cin >> w[n];
        lt.insert(toupper(w[n]));
    }
    (lt.size() == 26) ? cout << "YES" : cout << "NO";
    return 0;
}
