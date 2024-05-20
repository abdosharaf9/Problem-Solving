#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

ll def(string a, string b, ll n)
{
    ll t = 0;
    for(ll i = 0; i < n; i++)
    {
        t += abs(a[i] - b[i]);
    }
    return t;
}

int main()
{
    ll t; cin >> t;
    while(t--)
    {
        ll n, l; cin >> n >> l;
        string arr[n];

        for(ll i = 0; i < n; i++)
            cin >> arr[i];

        ll m = INT_MAX, temp;
        for(ll i = 0; i < n-1; i++)
        {
            for(ll j = i+1; j < n; j++)
            {
                temp = def(arr[i], arr[j], l);
                m = min(m, temp);
            }
        }
        cout << m << "\n";
    }


    return 0;
}


/*
cout << convertToASCII("abb") << "\n";
cout << convertToASCII("zba") << "\n";
cout << convertToASCII("bef") << "\n";
cout << convertToASCII("cdu") << "\n";
cout << convertToASCII("ooo") << "\n";
cout << convertToASCII("zzz") << "\n";
*/
