#include <iostream>
using namespace std;
int main()
{
	int t, n[1000], a = 0;
	cin >> t;

	for(int i = 0; i < 1000; i++)
	{
		cout << "N[" << i << "] = " << a << endl;
		a++;
		if(a == t) a = 0;
	}

	return 0;
}