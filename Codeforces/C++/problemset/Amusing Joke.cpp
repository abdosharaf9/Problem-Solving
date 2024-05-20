// Problem Link: https://codeforces.com/problemset/problem/141/A

#include <iostream>
#include <string>
using namespace std;
typedef long long ll;
void b_sort(string &x)
{
    for(ll i = 0; i < x.size()-1; i++)
    {
        for(ll j = 0; j < x.size()-i-1; j++)
        {
            if(x[j] > x[j+1]) swap(x[j],x[j+1]);
        }
    }
}
int main()
{
    string s1,s2,s3;
    cin >> s1 >> s2 >> s3;
    s1 = s1 + s2;
    if(s1.size() != s3.size()) cout << "NO";
    else
    {
        b_sort(s1);
        b_sort(s3);
        for(ll i = 0; i < s1.size(); i++)
            if(s1[i] != s3[i]){cout << "NO"; return 0;}
        cout << "YES";
    }
    return 0;
}
