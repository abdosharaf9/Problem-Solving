#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll tc = 1; cin >> tc;
    while(tc--)
    {
        ll n; cin >> n;
        pair <ll, ll> sleep; cin >> sleep.first >> sleep.second;
        vector <pair<ll, ll>> v(n);

        for(ll i = 0; i < n; i++)
        {
            cin >> v[i].first >> v[i].second;
        }

        sort(v.begin(), v.end());

        /*for(ll i = 0; i < n; i++)
        {
            cout << v[i].first << "\t" << v[i].second << "\n";
        }*/

        for(ll i = 0; i < n; i++)
        {
            if(v[i].first == sleep.first and v[i].second == sleep.second){
                cout << "0 0\n";
                break;
            }
            else if(v[i].first == sleep.first and v[i].second > sleep.second){
                cout << "0 " << v[i].second - sleep.second << "\n";
                break;
            }
            else if(v[i].first > sleep.first and v[i].second == sleep.second){
                cout << v[i].first - sleep.first << " 0\n";
                break;
            }
            else if(v[i].first > sleep.first and v[i].second < sleep.second){
                v[i].first--; v[i].second++;
                cout << v[i].first - sleep.first << " " << v[i].second - sleep.second << "\n";
                break;
            }
            else if(v[i].first > sleep.first and v[i].second > sleep.second){
                cout << v[i].first - sleep.first << " " << v[i].second - sleep.second << "\n";
                break;
            }
        }

    }

    return 0;
}

/*
1 6 13
8 0

7 60 - 6 13 = 1 47
*/
