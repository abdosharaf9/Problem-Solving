//wrong answer on test 4

#include <iostream>
#include <string>
using namespace std;
typedef long long ll;
typedef string ss;
int main()
{
    ss s, sn, result; cin >> s;
    ll n, let, letpre = 0; cin >> n;
    for(ll i = 0; i < n; i++)
    {
        let = 0;
        cin >> sn;
        for(ll j = 0; j < sn.size(); j++)
        {
            if(sn[j] != s[j]) let++;
        }
        if(i == 0 || let < letpre) {letpre = let; result = sn;}
    }
    cout << result;
    return 0;
}
