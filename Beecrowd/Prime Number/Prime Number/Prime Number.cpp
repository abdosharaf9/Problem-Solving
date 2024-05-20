#include <iostream>
using namespace std;
int main()
{
	int n, x, p = 0;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> x;

		for(int j = 1; j < x; j++)
		{
			if(x % j == 0)
				p+=j;
		}
		if(p == 1)
			cout << x << " eh primo" << endl;
		else
			cout << x << " nao eh primo" << endl;
		p = 0;
	}

	return 0;
}