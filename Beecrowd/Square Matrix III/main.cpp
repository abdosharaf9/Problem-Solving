#include <iostream>
#include <cmath>
using namespace std;
int main()
{
    int n;
    while(cin >> n && n != 0)
    {
        int x = 1, y = 1;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                cout << y << " " ;
                y*= 2;
            }
            cout << "\n";
            y = sqrt(y);
            x*= 2;
        }
    }

    return 0;
}
