#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll h, m, s; cin >> h >> m >> s;
    char a; cin >> a;
    if(a == 'P') h += 12;
    cout << h * 3600 + m * 60 + s;
    return 0;
}
