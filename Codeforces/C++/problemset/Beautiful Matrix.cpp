// Problem Link: https://codeforces.com/problemset/problem/263/A

#include <iostream>
using namespace std;

int main()
{
    int a[5][5],x,y;
    for(int i = 0; i < 5; i++)
        for(int j = 0; j < 5; j++)
            cin >> a[i][j];
    if(a[2][2] == 1)
        cout << 0;
    else
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(a[i][j] == 1)
                {
                   x = i;
                   y = j;
                   break;
                }
            }
        }
        cout << abs(x - 2) + abs(y - 2);

    }

    return 0;
}
