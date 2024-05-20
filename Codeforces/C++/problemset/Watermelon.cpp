// Problem Link: https://codeforces.com/problemset/problem/4/A

#include <iostream>
using namespace std;

int main()
{
    long long w;
    cin >> w;
    (w > 2 && w%2 == 0) ? cout << "YES" : cout << "NO";

    return 0;
}
