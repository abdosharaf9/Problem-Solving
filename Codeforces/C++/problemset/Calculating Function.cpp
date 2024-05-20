// Problem Link: https://codeforces.com/problemset/problem/486/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, ne = -1, r = 0, po = 2, i = 0;
    cin >> n;
    while(i != n/2)
    {
        r = r + ne + po;
        po+=2; ne-=2; i++;
    }
    if(n%2 != 0) r+= ne;
    cout << r;
    return 0;
}
