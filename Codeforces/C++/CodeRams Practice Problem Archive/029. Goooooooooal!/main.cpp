#include <iostream>
#include <string>
using namespace std;
typedef long long ll;
int main()
{
    string s; cin >> s;
    ll o = 0;
    for(ll i = 1; i < s.size()-2; i++)
    {
        if(s[i] = 'o') o++;
    }
    cout << o;
    return 0;
}
