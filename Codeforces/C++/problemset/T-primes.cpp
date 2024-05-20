// Problem Link: https://codeforces.com/problemset/problem/230/B

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

bool isPrime(ll n)
{
    if(n == 2) return true;
    if(n % 2 == 0) return false;
    for(ll i = 3; i <= sqrt(n); i+=2)
    {
        if(n % i == 0) return false;
    }
    return true;
}

int main()
{
    ll t; cin >> t;
    while(t--)
    {
        ll n; cin >> n;
        ll x = sqrt(n);
        if(isPrime(x) and x*x == n and n != 1) cout << "YES\n";
        else cout << "NO\n";
    }
    return 0;
}





/*#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll t; cin >> t;
    while(t--)
    {
        ll n, divs = 2; cin >> n;
        for(ll i = 2; i <= sqrt(n); i++)
        {
            if(i == sqrt(n) && n % i == 0) divs++;
            else if(n % i == 0) divs += 2;

            if(divs > 3) break;
        }
        if(divs == 3) cout << "YES\n";
        else cout << "NO\n";
    }
    return 0;
}*/



/*
//Time limit on test 5 --> 999966000289
#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, x, d;
    cin >> n;
    for(ll i = 0; i < n; i++)
    {
        d = 2;
        bool h = true;
        cin >> x;
        for(ll j = 2; j <= x/2; j++)
        {
            if(x % j == 0) d++;
            if(d > 3)
            {
                cout << "NO\n";
                h = false;
                break;
            }
        }
        if(h == true)
        {
            if(d == 3) cout << "YES\n";
            else cout << "NO\n";
        }
    }
    return 0;
}
*/
