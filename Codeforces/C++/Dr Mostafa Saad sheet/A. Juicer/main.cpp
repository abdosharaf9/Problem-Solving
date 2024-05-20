#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll n, b, d, o, times = 0, sum = 0; cin >> n >> b >> d;

    for(ll i = 0; i < n; i++)
    {
        cin >> o;
        if(o <= b)
        {
            sum += o;
        }
        if(sum > d)
        {
            times++;
            sum = 0;
        }
    }
    cout << times;
    return 0;
}

/*
Input
n = 3, b = 10, d = 10
o1 = 5 --> sum = 5, times = 0
o2 = 7 --> sum = 12 --> times = 1, sum = 0
o3 = 7 --> sum = 7, times = 1

Output
1
-----------------------------------------------
Input
n = 2, b = 951637, d = 951638
o1 = 44069 --> sum = 44069, times = 0
o2 = 951637 --> sum = 995706 -- > times = 1, sum = 0

Output
1
*/
