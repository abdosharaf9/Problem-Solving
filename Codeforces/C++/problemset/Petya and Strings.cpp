// Problem Link: https://codeforces.com/problemset/problem/112/A

#include <iostream>
#include <string>
using namespace std;
int main()
{
    string x,y;
    cin >> x >> y;
    for(int i = 0; i < x.size(); i++)
    {
        x[i] = toupper(x[i]);
        y[i] = toupper(y[i]);
        if(x[i] > y[i])
        {
            cout << 1;
            return 0;
        }

        else if(x[i] < y[i])
        {
            cout << -1;
            return 0;
        }
    }
    cout << 0;

    return 0;
}
