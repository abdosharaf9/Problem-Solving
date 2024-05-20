#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	float sal, n;
	cin >> sal;

	if(sal > 0 && sal <= 400.00)
	{
		n = 0.15 * sal;
		cout << "Novo salario: " << fixed << setprecision(2) << (sal + n) << endl;
		cout << "Reajuste ganho: " << fixed << setprecision(2) << n << endl;
		cout << "Em percentual: 15 %" << endl;
	}
	else if(sal > 400.00 && sal <= 800.00)
	{
		n = 0.12 * sal;
		cout << "Novo salario: " << fixed << setprecision(2) << (sal + n) << endl;
		cout << "Reajuste ganho: " << fixed << setprecision(2) << n << endl;
		cout << "Em percentual: 12 %" << endl;
	}
	else if(sal > 800.00 && sal <= 1200.00)
	{
		n = 0.10 * sal;
		cout << "Novo salario: " << fixed << setprecision(2) << (sal + n) << endl;
		cout << "Reajuste ganho: " << fixed << setprecision(2) << n << endl;
		cout << "Em percentual: 10 %" << endl;
	}
	else if(sal > 1200.00 && sal <= 2000.00)
	{
		n = 0.07 * sal;
		cout << "Novo salario: " << fixed << setprecision(2) << (sal + n) << endl;
		cout << "Reajuste ganho: " << fixed << setprecision(2) << n << endl;
		cout << "Em percentual: 7 %" << endl;
	}
	else if(sal > 2000)
	{
		n = 0.04 * sal;
		cout << "Novo salario: " << fixed << setprecision(2) << (sal + n) << endl;
		cout << "Reajuste ganho: " << fixed << setprecision(2) << n << endl;
		cout << "Em percentual: 4 %" << endl;
	}

	return 0;
}