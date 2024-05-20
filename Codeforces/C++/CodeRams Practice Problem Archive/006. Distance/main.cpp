#include <iostream>
#include <math.h>
#include <iomanip>
using namespace std;
typedef long long ll;
int main()
{
    ll x1, y1, x2, y2;
    cin >> x1 >> y1 >> x2 >> y2;
    double result = sqrt(pow((x2 - x1), 2) + pow((y2 - y1), 2));
    cout << fixed << setprecision(16) << result;
    return 0;
}
