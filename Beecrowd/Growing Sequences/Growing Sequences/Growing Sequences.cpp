#include <iostream>
using namespace std;
int main()
{
	int x;
	while(true)
	{
		cin >> x;
		if (x == 0) break;

		for(int i = 1; i <= x; ++i)
		{
			if(i == x)
				cout << i << "\n";
			else
				cout << i << " ";
		}
	}

	return 0;
}