#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
    double vi; cin >> vi;
    cout << fixed << setprecision(16) << (0 - (vi * vi)) / (2 * -9.8);
    return 0;
}

/*
vf^2 = vi^2 + 2ad;
>> vi
vf = 0
a = -9.8
we need (d)
d = (0 - vi^2) / (2a)
*/
