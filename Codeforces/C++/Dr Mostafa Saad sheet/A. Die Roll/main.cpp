#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll y, w; cin >> y >> w;
    string prop[] = {"1/6", "1/3", "1/2", "2/3", "5/6", "1/1"};
    y = max(y, w);
    cout << prop[6-y];
    return 0;
}
