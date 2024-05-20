#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	double A, B, C, MED;
	cin >> A >> B >> C;
	MED = (((A * 2) + (B * 3) + (C * 5)) / (2 + 3 + 5));
	cout << "MED = " << fixed << setprecision(1) << MED << endl;
	return 0;
}