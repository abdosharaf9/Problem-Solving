#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	int x, y;
	cin >> x >> y;

	if(x == 1)
		cout << "Total: R$ " << fixed << setprecision(2) << y * 4.00 << endl;
	else if (x == 2)
		cout << "Total: R$ " << fixed << setprecision(2) << y * 4.50 << endl;
	else if (x == 3)
		cout << "Total: R$ " << fixed << setprecision(2) << y * 5.00 << endl;
	else if (x == 4)
		cout << "Total: R$ " << fixed << setprecision(2) << y * 2.00 << endl;
	else if (x == 5)
		cout << "Total: R$ " << fixed << setprecision(2) << y * 1.50 << endl;

	return 0;
}