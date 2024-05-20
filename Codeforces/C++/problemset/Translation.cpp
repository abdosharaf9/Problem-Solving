// Problem Link: https://codeforces.com/problemset/problem/41/A

#include <iostream>
#include <string>
using namespace std;
int main()
{
    string s,t;
    cin >> s >> t;
    long long j = s.size() - 1;
    for(long long i = 0; i < s.size(); i++)
    {
        if(s[i] != t[j])
        {
            cout << "NO";
            return 0;
        }
        j--;
    }
    cout << "YES";

    return 0;
}
