#include <iostream>
using namespace std;
int main()
{
	int days, x;
	cin >> days;
	cout << days / 365 << " ano(s)" << endl;
	x = days % 365;
	cout << x / 30 << " mes(es)" << endl;
	x = x % 30;
	cout << x << " dia(s)" << endl;

	return 0;
}