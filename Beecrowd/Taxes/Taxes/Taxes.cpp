#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	float sal;
	cin >> sal;
	if (sal <= 2000.00)
		cout << "Isento" << endl;
	else if (sal > 2000.00 && sal <= 3000.00)
		cout << "R$ " << fixed << setprecision(2) << (sal - 2000.00) * 0.08 << endl;
	else if (sal > 3000.00 && sal <= 4500.00)
		cout << "R$ " << fixed << setprecision(2) << (sal - 3000.00) * 0.18 + (1000.00 * 0.08) << endl;
	else if (sal > 4500.00)
		cout << "R$ " << fixed << setprecision(2) << (sal - 4500.00) * 0.28 + (1500.00 * 0.18) + (1000.00 * 0.08) << endl;

	return 0;
}