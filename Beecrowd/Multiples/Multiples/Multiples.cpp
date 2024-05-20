#include <iostream>
 
using namespace std;
 
int main()
{
	int a, b;
	cin >> a >> b;

	if (b > a)
	{
		if(b % a == 0)
			cout << "Sao Multiplos" << endl;
		else if(b % a != 0)
			cout << "Nao sao Multiplos" << endl;
	}
	else if (a > b)
	{
		if(a % b == 0)
			cout << "Sao Multiplos" << endl;
		else if(a % b != 0)
			cout << "Nao sao Multiplos" << endl;
	}
	

	return 0;
}