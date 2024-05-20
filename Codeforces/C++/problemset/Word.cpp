// Problem Link: https://codeforces.com/problemset/problem/59/A

#include <iostream>
#include <string>
using namespace std;
int main()
{
    string s;
    cin >> s;
    long long u = 0,l = 0;
    for(long long i = 0; i < s.size(); i++)
    {
        if(isupper(s[i])) u++;
        if(islower(s[i])) l++;
    }
    if(l >= u)
    {
        for(long long i = 0; i < s.size(); i++)
        {
            s[i] = tolower(s[i]);
        }
    }
    else
    {
        for(long long i = 0; i < s.size(); i++)
        {
            s[i] = toupper(s[i]);
        }
    }
    cout << s;

    return 0;
}
