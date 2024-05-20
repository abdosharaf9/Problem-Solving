#include <iostream>
#include <string>
using namespace std;
typedef long long ll;
int main()
{
    string s1, s2, s3, s4; cin >> s1 >> s2 >> s3 >> s4;
    ll p1, p2, p3, p4; cin >> p1 >> p2 >> p3 >> p4;
    ll sh1, sh2, sh3, sh4; cin >> sh1 >> sh2 >> sh3 >> sh4;
    p1 = p1 / sh1; p2 = p2 / sh2; p3 = p3 / sh3; p4 = p4 / sh4;
    if(max(p1, max(p2, max(p3, p4))) == p1) cout << s1;
    else if(max(p1, max(p2, max(p3, p4))) == p2) cout << s2;
    else if(max(p1, max(p2, max(p3, p4))) == p3) cout << s3;
    else cout << s4;
    return 0;
}
