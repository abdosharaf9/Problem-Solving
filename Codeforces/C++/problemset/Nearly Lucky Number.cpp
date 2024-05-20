// Problem Link: https://codeforces.com/problemset/problem/110/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, t = 0;
    cin >> n;
    while(n > 0)
    {
        if(n%10 == 4 || n%10 == 7) t++;
        n/= 10;
    }
    if(t != 0)
    {
        while(t > 0)
        {
            if(t%10 != 4 && t%10 != 7)
            {
                cout << "NO";
                return 0;
            }
            t/= 10;
        }
        cout << "YES";
    }
    else cout << "NO";

    return 0;
}
