#include <iostream>
using namespace std;
int main()
{
	int m, n, sum = 0;

	while (true)
	{
		cin >> m >> n;
		if(m <= 0) break;
		if(n <= 0) break;

		if (m > n)
		{
			int tmp;
			tmp = m;
			m = n;
			n = tmp;
		}

		for (int i = m; i <= n; ++i)
		{
			cout << i << " ";
			sum+= i;
		}

		cout << "Sum=" << sum << endl;
		sum = 0;
	}

	return 0;
}