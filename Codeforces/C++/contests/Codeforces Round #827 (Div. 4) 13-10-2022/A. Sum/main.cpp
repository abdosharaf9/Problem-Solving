#include <bits/stdc++.h>
using namespace std;
#define ll long long

int main()
{
    ll tc, a, b, c;; cin >> tc;
    while(tc--)
    {
        cin >> a >> b >> c;
        if(a+b == c or a+c == b or b+c == a) cout << "YES\n";
        else cout << "NO\n";
    }

    return 0;
}
