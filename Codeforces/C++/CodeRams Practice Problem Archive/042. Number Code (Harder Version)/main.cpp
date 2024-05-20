#include <iostream>
#include <string>
using namespace std;
typedef long long ll;

string code(string x)
{
    string y = "";
    for(ll i = 0; i < x.size(); i++)
    {
        if(x[i] == 'o') y += '0';
        else if(x[i] == 'i') y += '1';
        else if(x[i] == 'e') y += '3';
        else if(x[i] == 'a') y += '4';
        else if(x[i] == 's') y += '5';
        else if(x[i] == 't') y += '7';
    }
    return y;
}

int main()
{
    ll k = 0; cin >> k;
    string dect[k];
    string dectcoded[k];
    for(ll i = 0; i < k; i++)
    {
        cin >> dect[i];
        dectcoded[i] = code(dect[i]);
    }
    ll n, how; cin >> n;
    string t;
    for(ll i = 0; i < n; i++)
    {
        cin >> t;
        how = 0;
        for(ll j = 0; j < k; j++)
        {
            if(dectcoded[j] == t) how++;
        }
        cout << how << "\n";
        for(ll j = 0; j < k; j++)
        {
            if(dectcoded[j] == t)
                cout << dect[j] << "\n";
        }
    }
    return 0;
}

/*
Input:-
8
fantastic
funtastuc
hasty
taste
tasted
tastes
tasty
untasty
3
457
7457
74573

Output:-
1
hasty
3
funtastuc
tasty
untasty
2
taste
tasted
*/
