// Problem Link: https://codeforces.com/problemset/problem/546/A

#include <iostream>
using namespace std;
int main()
{
    long long k,n,w,sum = 0;
    cin >> k >> n >> w;
    for(int i = 1; i <= w; i++)
        sum += i*k;
    if(n >= sum)
        cout << 0;
    else
        cout << sum - n;
    return 0;
}
