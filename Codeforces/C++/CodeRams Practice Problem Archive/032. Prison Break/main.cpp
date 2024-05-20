#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, l, h, sum = 1; cin >> n;
    for(ll i = 0; i < n; i++)
    {
        cin >> l >> h;
        sum *= ((h - l) + 1);
    }
    cout << sum;
    return 0;
}

/*
input:
3
1   2   -> 1,2      -> 2
1   3   -> 1,2,3    -> 3
11 12   -> 11,12    -> 2

2 * 3 * 2 -> 12

output: 12
*/
