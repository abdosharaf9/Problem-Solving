#include <iostream>
#include <string>
using namespace std;
typedef long long ll;
int main()
{
    ll s1 = 0, s2 = 0, s3 = 0, s4 = 0, c1, c2, c3, c4; cin >> c1 >> c2 >> c3 >> c4;
    string s; cin >> s;
    for(ll i = 0; i < s.size(); i++)
    {
        if(s[i] == '1') s1++;
        else if(s[i] == '2') s2++;
        else if(s[i] == '3') s3++;
        else if(s[i] == '4') s4++;
    }
    cout << s1*c1 + s2*c2 + s3*c3 + s4*c4;
    return 0;
}
