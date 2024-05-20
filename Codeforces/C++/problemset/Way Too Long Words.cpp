// Problem Link: https://codeforces.com/problemset/problem/71/A

#include <iostream>
#include <string>
using namespace std;
int main()
{
    long long n;
    string s;
    cin >> n;
    for(int i = 0; i < n; i++)
    {
        cin >> s;
        if(s.size() > 10)
            cout << s[0] << s.size() - 2 << s[s.size() - 1] << "\n";
        else
            cout << s << "\n";
    }

    return 0;
}
