// Problem Link: https://codeforces.com/problemset/problem/510/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, m;
    cin >> n >> m;
    for(ll i = 0; i < n; i++)
    {
        for(ll j = 0; j < m; j++)
        {
            if(i%2 == 0) cout << "#";
            else
            {
                if(i%4 == 1 && j == m-1) cout <<  "#";
                else if(i%4 == 3 && j == 0) cout << "#";
                else cout << ".";
            }
        }
        cout << "\n";
    }
    return 0;
}
