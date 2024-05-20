#include <iostream>
#include <string>
using namespace std;
typedef long long ll;

string code(string s)
{
    for(ll i = 0; i < s.size(); i++)
    {
        if(s[i] == '0') s[i] = 'o';
        else if(s[i] == '1') s[i] = 'i';
        else if(s[i] == '3') s[i] = 'e';
        else if(s[i] == '4') s[i] = 'a';
        else if(s[i] == '5') s[i] = 's';
        else if(s[i] == '7') s[i] = 't';
        else if(s[i] == ' ') s[i] = ' ';
    }
    return s;
}

int main()
{
    ll n; string s; cin >> n;
    for(ll i = 0; i <= n; i++)
    {
        getline(cin, s);
        cout << code(s) << "\n";
    }
    return 0;
}
