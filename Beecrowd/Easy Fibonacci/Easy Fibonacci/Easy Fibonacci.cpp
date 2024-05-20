#include <iostream>
using namespace std;
int main()
{
	/*int n, a = 0, b = 1, c;

	cin >> n;

	for (int i = 0; i <= n; ++i)
	{
		cout << a << " ";
		c = a + b;
		a = b;
		b = c;
	}*/

	int n, fib[46];

	cin >> n;

	fib[0] = 0, fib[1] = 1;
	cout << fib[0] << " " << fib[1] << " " ;

	for (int i = 2; i < n; i++)
	{
		fib[i] = fib[i-1] + fib[i-2];

		if(i == (n-1))
			cout << fib[i] << "\n";
		else
			cout << fib[i] << " ";
	}

	return 0;
}