#include <iostream>
using namespace std;
int main()
{
	int n, ctr = 0;
	for (int i = 0; i < 5; i++)
	{
		cin >> n;
		if (n < 0)
			n = -n;
		if (n % 2 == 0)
			ctr++;
	}
	cout << ctr << " valores pares" << endl;

	return 0;
}