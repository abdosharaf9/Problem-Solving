#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll tc; cin >> tc;
    while(tc--)
    {
        char b[8][8];
        for(ll i = 0; i < 8; i++)
        {
            for(ll j = 0; j < 8; j++)
            {
                cin >> b[i][j];
            }
        }

        bool f = false;
        for(ll i = 1; i < 8; i++)
        {
            for(ll j = 1; j < 8; j++)
            {
                if(b[i][j-1] == '.' and b[i][j+1] == '.'
                and b[i-1][j] == '.' and b[i+1][j] == '.'
                and b[i-1][j-1] == '#' and b[i-1][j+1] == '#'
                and b[i+1][j-1] == '#' and b[i+1][j+1] == '#') {cout << i+1 << " " << j+1 << "\n"; break; f = true;}
            }
            if(f) break;
        }

    }
    return 0;
}

/*
#include<bits/stdc++.h>
#define ll long long int
using namespace std;
int main() 
{ 
          ios_base::sync_with_stdio(0);
               cin.tie(0);
             cout.tie(0); 
            // freopen(file.in,"r",stdin);

char arr[8][8];
int test,i,c;
cin>>test;
for (int t = 0;t < test;t++)
{
for ( i = 0; i < 8; i++)
{
    for( c=0;c<8;c++)
    {
       cin>>arr[i][c];
    }
 
}


for ( i = 0; i < 8; i++)
{
    bool flag=1;
    for( c=0;c<8;c++)
    {
       if(arr[i][c]=='#'&&arr[i][c-1]=='.'&&arr[i][c+1]=='.'&&arr[i-1][c]=='.'&&arr[i+1][c]=='.'&&arr[i-1][c-1]=='#'&&arr[i-1][c+1]=='#'&&arr[i+1][c-1]=='#'&&arr[i+1][c+1]=='#')
       {
        flag=0;
        break;
       }
       if(flag==0)
       break;
    }
 if(flag==0)
 cout<<i+1<<" "<<c+1;
}

    if(t!=test-1)
    cout<<endl;
}
}
*/