#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	int a, b;
	double c, SALARY;
	cin >> a >> b >> c;
	SALARY = b * c;
	cout << "NUMBER = " << a << endl;
	cout << "SALARY = U$ " << fixed << setprecision(2) << SALARY << endl;

	return 0;
}