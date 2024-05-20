// Problem Link: https://codeforces.com/problemset/problem/266/A

#include <iostream>
using namespace std;
int main()
{
    long long n,x = 0;
    cin >> n;
    char *s = new char[n];
    for(long long i = 0; i < n; i++)
    {
        cin >> s[i];
        if(i > 0 && s[i] == s[i-1]) x++;
    }
    cout << x;
    delete [] s;
    return 0;
}
