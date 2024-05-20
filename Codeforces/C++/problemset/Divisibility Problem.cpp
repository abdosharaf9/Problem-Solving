// Problem Link: https://codeforces.com/problemset/problem/1328/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll t, a, b, x;
    cin >> t;
    for(ll i = 0; i < t; i++)
    {
        x = 0;
        cin >> a >> b;
        if(a%b != 0)
        {
            x = a%b;
            cout << b - x << "\n";
        }
        else cout << "0\n";
    }
    return 0;
}
