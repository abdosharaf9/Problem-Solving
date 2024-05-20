#include <iostream>
using namespace std;
int main()
{
	int x, y, n = 1;
	cin >> x >> y;

	for(int i = 1; i <= y; i++)
	{
		if(n == x)
		{
			cout << i << "\n";
			n = 1;
		}
		else
		{
			cout << i << " ";
			n++;
		}
	}
			
	return 0;
}

/*for(int i = 1; i <= y/x; i++)
	{
		cout << n << " " << n+1 << " " << n+2 << "\n";
		n+= 3;
	}*/
