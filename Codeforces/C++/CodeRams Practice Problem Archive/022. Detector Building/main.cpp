#include <iostream>
#include <math.h>
#include <iomanip>
using namespace std;
int main()
{
    double r1, r2, r3, t1, t2, t3, l1, l2, l3, y1, y2, y3, i2, i3, A, B, C;
    cin >> t1 >> t2 >> t3 >> r1 >> r2 >> r3;
    l1 = log(r1); l2 = log(r2); l3 = log(r3);
    y1 = 1/t1; y2 = 1/t2; y3 = 1/t3;
    i2 = (y2 - y1) / (l2 - l1);
    i3 = (y3 - y1) / (l3 - l1);
    C = ((i3 - i2) / (l3 - l2)) * pow((l1 + l2 + l3), -1);
    B = i2 - (C * ((l1 * l1) + (l1 * l2) + (l2 * l2)));
    A = y1 - (l1 * (B + (l1 * l1 * C)));
    cout << fixed << setprecision(13) << A;
    return 0;
}
