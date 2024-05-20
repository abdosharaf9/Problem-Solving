#include <iostream>
using namespace std;
int main()
{
	int t, n;
	long long fib[61];
	cin >> t;

	fib[0] = 0;
	fib[1] = 1;

	for(int i = 2; i < 60; i++)
	{
		fib[i] = fib[i-2] + fib[i-1];
	}

	for(int i = 0; i < t; i++)
	{
		cin >> n;
		cout << "Fib(" << n << ") = " << fib[n] << endl;
	}

	return 0;
}