#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll t; cin >> t;
    while(t--)
    {
        ll n; cin >> n;
        ll arr[n];

        for(ll i = 0; i < n; i++)
            cin >> arr[i];

        if(n == 1 && arr[0] == 1)
            cout << "YES\n";
        else if(n == 1 && arr[0] > 1)
            cout << "NO\n";
        else
        {
            ll f = 1, *mx;
            while(f)
            {
                mx = max_element(arr, arr+n);
                if(*mx == 0)
                    break;
                (*mx)--;
                if(max_element(arr, arr+n) == mx && count(arr, arr+n, *mx) == 1)
                {
                    f = 0;
                }
            }

            if(f == 1)
                cout << "YES\n";
            else
                cout << "NO\n";
        }
    }
    return 0;
}

/*
sort(arr, arr+n);
if(arr[n-1] - arr[n-2] > n)
    cout << "NO\n";
else
    cout << "YES\n";
*/
/*
5
1 6 2 4 3

NO
*/
