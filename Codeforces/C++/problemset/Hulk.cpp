// Problem Link: https://codeforces.com/problemset/problem/705/A

#include <iostream>
using namespace std;
int main()
{
    long long n;
    cin >> n;
    for(long long i = 0; i < n; i++)
    {
        if(i%2 == 0)
            cout << "I hate ";
        else
            cout << "I love ";
        if((n - i) != 1)
            cout << "that ";
    }
    cout << "it";
    return 0;
}
