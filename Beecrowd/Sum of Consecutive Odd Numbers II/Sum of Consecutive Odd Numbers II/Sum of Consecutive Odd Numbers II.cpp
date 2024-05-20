#include <iostream>
using namespace std;
int main()
{
	int n, x, y, sum = 0;
	cin >> n;

	for (int i = 0; i < n; ++i)
	{
		cin >> x >> y;
		if (x > y)
		{
			int tmp;
			tmp = x;
			x = y;
			y = tmp;
		}
		for (int i = x + 1; i < y; ++i)
		{
			if (i % 2 != 0)
				sum += i;
		}
		cout << sum << endl;
		sum = 0;
	}

	return 0;
}