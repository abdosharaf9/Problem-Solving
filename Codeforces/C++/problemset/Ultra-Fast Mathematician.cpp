// Problem Link: https://codeforces.com/problemset/problem/61/A

#include <iostream>
#include <string>
using namespace std;
int main()
{
    string x,y;
    cin >> x >> y;
    for(int i = 0; i < x.size(); i++)
    {
        if(x[i] == y[i])
            cout << 0;
        else
            cout << 1;
    }


    return 0;
}
