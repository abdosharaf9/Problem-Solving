#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	int time, speed;
	cin >> time >> speed;
	cout << fixed << setprecision(3) << ((time * speed) / 12.0) << endl;

	return 0;
}