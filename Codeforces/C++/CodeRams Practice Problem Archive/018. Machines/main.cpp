#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
    double a, b, n; cin >> n;
    while(n >= 1){cin >> a >> b; cout << fixed << setprecision(16) << a/b << "\n"; n--;}
    return 0;
}
