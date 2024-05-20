#include <iostream>
using namespace std;
int main()
{
	int x, z, b = 0,n = 0;
	cin >> x;

	do
	{
		cin >> z;
	}while(z <= x);

	for(int a = x; b < z; ++a)
	{
		b+= a;
		n++;
	}

	cout << n << endl;

	return 0;
}