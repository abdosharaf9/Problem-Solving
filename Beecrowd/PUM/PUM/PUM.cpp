#include <iostream>
using namespace std;
int main()
{
	int n, x = 1;
	cin >> n;

	for (int i = 0; i < n; ++i)
	{
		cout << x <<" ";
		x++;
		cout << x << " ";
		x++;
		cout << x << " PUM" << endl;
		x += 2;
	}

	return 0;
}