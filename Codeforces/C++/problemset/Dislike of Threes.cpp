// Problem Link: https://codeforces.com/problemset/problem/1560/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll t, k;
    cin >> t;
    for(ll i = 0; i < t; i++)
    {
        ll no = 1, fin, x = 1;
        cin >> k;
        while(x <= k)
        {
            if((no % 3) != 0 && (no % 10) != 3)
            {
                fin = no;
                x++;
            }
            no++;
        }
        cout << fin << "\n";
    }
    return 0;
}
