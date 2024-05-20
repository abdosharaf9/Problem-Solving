#include <iostream>
using namespace std;
int main()
{
	int n[20], tmp, x = 19;

	for(int i = 0; i < 20; i++)
	{
		cin >> n[i];
	}

	for(int i = 0; i < 10; i++)
	{
		tmp = n[i];
		n[i] = n[x];
		n[x] = tmp;
		x--;
	}

	for(int i = 0; i < 20; i++)
	{
		cout << "N[" << i << "] = " << n[i] << endl;
	}

	return 0;
}