// Problem Link: https://codeforces.com/problemset/problem/158/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n,k,p = 0;
    cin >> n >> k;
    ll *a = new ll[n];
    for(int i = 0; i < n; i++)
        cin >> a[i];
    for(int i = 0; i < n; i++)
        if(a[i] >= a[k - 1] && a[i] > 0) p++;
    cout << p;
    delete [] a;
    return 0;
}
