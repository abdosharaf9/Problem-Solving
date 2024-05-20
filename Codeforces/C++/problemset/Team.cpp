// Problem Link: https://codeforces.com/problemset/problem/231/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n,x,y,z,a = 0;
    cin >> n;
    for(int i = 0; i < n; i++)
    {
        cin >> x >> y >> z;
        if((x+y+z) >= 2)
            a++;
    }
    cout << a;
    return 0;
}
