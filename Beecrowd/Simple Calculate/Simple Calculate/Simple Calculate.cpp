#include <iostream>
#include <iomanip>
using namespace std;
int main ()
{
	int code1, code2, num1, num2;
	float price1, price2;

	cin >> code1 >> num1 >> price1;
	cin >> code2 >> num2 >> price2;
	cout << "VALOR A PAGAR: R$ " << fixed << setprecision(2) << ((num1 * price1)+(num2 * price2)) << endl;

	return 0;
}