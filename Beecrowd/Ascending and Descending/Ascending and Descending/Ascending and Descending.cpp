#include <iostream>
using namespace std;
int main()
{
	int x, y;

	while (true)
	{
		cin >> x >> y;
		if(x == y) break;

		if (x > y)
			cout << "Decrescente" << endl;
		if (y > x)
			cout << "Crescente" << endl;
	}

	return 0;
}