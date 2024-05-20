#include <iostream>
using namespace std;
int main()
{
	int n, max = 0, p = 0;
	for (int i = 0; i < 100; i++)
	{
		cin >> n;
		if (n > max)
			max = n; p = i;
	}

	cout << max << "\n" << p + 1 << endl;

	return 0;
}