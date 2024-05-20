#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll tc; cin >> tc;
    while(tc--)
    {
        ll n; cin >> n;
        string arr[n], res = "";
        set <string> s;

        for(ll i = 0; i < n; i++)
        {
            cin >> arr[i];
            s.insert(arr[i]);
        }

        for(ll i = 0; i < n; i++)
        {
            string si = arr[i];
            bool f = 0;
            for(ll j = 0; j < si.size()-1; j++)
            {
                string x = si.substr(0, j+1);
                string y = si.substr(j+1, n-j+1);

                if(s.find(x) != s.end() and s.find(y) != s.end())
                {
                    res += '1';
                    f = 1;
                    break;
                }
            }
            if(!f) res += '0';
        }

        cout << res << "\n";
    }

    return 0;
}

/*
Test case #1
5
abab
ab
abc
abacb
c

10100
abab = ab + ab
abc = ab + c
*/





/*#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll tc = 1; cin >> tc;
    while(tc--)
    {
        ll n; cin >> n;
        string arr[n];
        bool res[n]{};

        for(ll i = 0; i < n; i++) cin >> arr[i];

        for(ll i = 0; i < n; i++)
        {
            for(ll j = 0; j < n; j++)
            {
                if(j == i) continue;
                for(ll k = 0; k < n; k++)
                {
                    if(k == i) continue;
                    string t = arr[j] + arr[k];
                    if(t == arr[i])
                    {
                        res[i] = 1;
                        k = n;
                        j = n;
                    }
                }
            }
        }
        for(ll i = 0; i < n; i++) cout << res[i];
        cout << "\n";
    }

    return 0;
}*/

