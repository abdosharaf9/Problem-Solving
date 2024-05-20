#include <iostream>
using namespace std;
int main()
{
	int v, x[10];
	cin >> v;

	x[0] = v;

	for (int i = 1; i < 10; i++)
	{
		x[i] = 2 * x[i-1];
	}
	for(int i = 0; i < 10; i++)
		cout << "N[" << i << "] = " << x[i] << endl;
	
	return 0;
}