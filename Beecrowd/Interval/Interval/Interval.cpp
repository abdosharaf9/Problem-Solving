#include <iostream>
using namespace std;
int main ()
{
	float x;
	cin >> x;
	if (x < 0.0000)
		cout << "Fora de intervalo" << endl;
	else if (x >= 0.0000 && x <= 25.0000)
		cout << "Intervalo [0,25]" << endl;
	else if (x > 25.0000 && x <= 50.0000)
		cout << "Intervalo (25,50]" << endl;
	else if (x > 50.0000 && x <= 75.0000)
		cout << "Intervalo (50,75]" << endl;
	else if (x > 75.0000 && x <= 100.0000)
		cout << "Intervalo (75,100]" << endl;
	else if (x > 100.0000)
		cout << "Fora de intervalo" << endl;
	return 0;
}