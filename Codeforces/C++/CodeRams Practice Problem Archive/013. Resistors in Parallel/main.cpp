#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
    double a, b, r; cin >> a >> b;r = (a * b)/(a + b);
    cout << fixed << setprecision(15) << r;
    return 0;
}
