// Problem Link: https://codeforces.com/problemset/problem/785/A

#include <iostream>
#include <string>
using namespace std;
typedef long long ll;
int main()
{
    ll n, f = 0;
    string p;
    cin >> n;
    for(ll i = 0; i < n; i++)
    {
        cin >> p;
        if(p == "Tetrahedron") f+= 4;
        else if(p == "Cube") f+= 6;
        else if(p == "Octahedron") f+= 8;
        else if(p == "Dodecahedron") f+= 12;
        else if(p == "Icosahedron") f+= 20;
    }
    cout << f;
    return 0;
}
