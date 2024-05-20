#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n,m,s; cin >> n >> m; s = ((n+m)/2.0)*(m-n+1); cout << s;
    /*
    OR:-
    ll n,m,s = 0; cin >> n >> m;
    for(ll i = n; i <= m; i++) s += i;
    cout << s;
    */
    return 0;
}
/*
1 --> 5
1+2+3+4+5 = 15

((1+5)/2) * 5 = 3*5 = 15

2 --> 2
2

((2+2)/2) * 1 = 2*1 = 2

sum of numbers from n to m = ((n + m)/2.0) * number of numbers
*/
