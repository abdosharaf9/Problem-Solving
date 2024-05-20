#include <bits/stdc++.h>
using namespace std;
#define ll long long

int main()
{
    ll tc; cin >> tc;
    while(tc--)
    {
        char arr[8][8];

        for(ll i = 0; i < 8; i++)
        {
            for(ll j = 0; j < 8; j++)
            {
                cin >> arr[i][j];
            }
        }

        bool columns = false;
        ll t = 0;

        for(ll i = 0; i < 8; i++)
        {
            for(ll j = 0; j < 8; j++)
            {
                if(arr[i][j] == 'R') t++;
            }

            if(t == 8)
            {
                cout << "R\n";
                columns = true;
                break;
            }

            t = 0;
        }

        if(!columns)
        {
            t = 0;
            for(ll i = 0; i < 8; i++)
            {
                for(ll j = 0; j < 8; j++)
                {
                    if(arr[j][i] == 'B') t++;
                }

                if(t == 8)
                {
                    cout << "B\n";
                    break;
                }
                t = 0;
            }
        }
    }
    return 0;
}
