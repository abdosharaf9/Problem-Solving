#include <iostream>
using namespace std;
typedef long long ll;
int prime(ll a)
{
    if(a == 1 || a == 2) {cout << "Yes"; return 0;}
    else
    {
        for(ll i = 2; i < a/2+1; i++) if(a%i == 0) {cout << "No"; return 0;}
        cout << "Yes";
        return 0;
    }
}
int main()
{
    ll x, s = 0; cin >> x;
    prime(x);
    /*
    OR:-
    for(ll i = 2; i < x/2+1; i++)
    {
        if(x%i == 0){cout << "No"; return 0;}
    }
    cout << "Yes";
    */
    return 0;
}
