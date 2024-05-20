#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	int age, sum = 0;
	float n = 0;

	cin >> age;
	do
	{
		sum+=age;
		n++;
		cin >> age;

	}while(age > 0);
	
	cout << fixed << setprecision(2) << sum/n << endl;

	return 0;
}