#include <iostream>
using namespace std;
int main()
{
	int n, x, div = 0;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> x;

		for(int j = 1; j < x; j++)
		{
			if (x % j == 0)
			{
				div+=j;
				if(div > x) break;
			}
		}

		if (div == x)
			cout << x << " eh perfeito" << endl;
		else
			cout << x << " nao eh perfeito" << endl;
		div = 0;
	}

	return 0;
}