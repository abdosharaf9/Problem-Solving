#include <iostream>
#include <math.h>
#include <iomanip>
using namespace std;
typedef long long ll;
int main()
{
    ll n, d1, d2; cin >> n;
    double sum = 0;
    for(ll i = 0; i < n; i++)
    {
        cin >> d1 >> d2;
        sum += pow((d2-d1),2);
    }
    cout << fixed << setprecision(13) << sqrt(sum);
    return 0;
}
