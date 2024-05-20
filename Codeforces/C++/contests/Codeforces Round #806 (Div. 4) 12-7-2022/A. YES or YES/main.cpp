#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll tc; cin >> tc;
    while(tc--)
    {
        char c1, c2, c3; cin >> c1 >> c2 >> c3;
        (tolower(c1) == 'y' and tolower(c2) == 'e' and tolower(c3) == 's')? cout << "YES\n" : cout << "NO\n";
    }

    return 0;
}
