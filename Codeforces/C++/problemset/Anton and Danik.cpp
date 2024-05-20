// Problem Link: https://codeforces.com/problemset/problem/734/A

#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, a = 0, d = 0;
    cin >> n;
    char g;
    for(ll i = 0; i < n; i++)
    {
        cin >> g;
        if(g == 'A') a++;
        else if(g == 'D') d++;
    }
    if(a > d) cout << "Anton";
    else if(d > a) cout << "Danik";
    else cout << "Friendship";



    return 0;
}
