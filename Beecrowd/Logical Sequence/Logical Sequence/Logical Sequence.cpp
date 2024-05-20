#include <iostream>
using namespace std;
int main()
{
	int n, x = 1;
	cin >> n;

	for (int i = 0; i < n; ++i)
	{
		cout << x << " ";
		cout << x*x << " ";
		cout << x*x*x << endl;
		cout << x << " ";
		cout << (x*x) + 1 << " ";
		cout << (x*x*x) + 1 << endl;
		x++;
	}
	return 0;
}