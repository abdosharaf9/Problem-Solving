#include <iostream>
#include <string>
#include <iomanip>
using namespace std;
int main()
{
	string name;
	double a, b, TOTAL;
	cin >> name >> a >> b;
	TOTAL = a + (0.15 * b);
	cout << "TOTAL = R$ " << fixed << setprecision(2) << TOTAL << endl;
	return 0;
}