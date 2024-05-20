// Problem Link: https://codeforces.com/problemset/problem/791/A

#include <iostream>
using namespace std;
int main()
{
    long long a,b,y = 0;
    cin >> a >> b;
    while(a <= b)
    {
        a *= 3;
        b *= 2;
        y++;
    }
    cout << y;
    return 0;
}
