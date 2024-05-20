#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	double a, b, x = 1;
	while(x == 1)
	{
		do{
			cin >> a;
			if (a < 0 || a > 10)
				cout << "nota invalida" << endl;
		}while(a < 0 || a > 10);

		do{
			cin >> b;
			if (b < 0 || b > 10)
				cout << "nota invalida" << endl;
		}while(b < 0 || b > 10);

		cout << "media = " << fixed << setprecision(2) << (a + b) / 2 << endl;

		do{
			cout << "novo calculo (1-sim 2-nao)" << endl;
			cin >> x;
		}while (x != 1 && x != 2);
		
	}
	

	return 0;
}

/*
#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	double a, b, x;
	do
	{
		do{
			cin >> a;
			if (a < 0 || a > 10)
				cout << "nota invalida" << endl;
		}while(a < 0 || a > 10);

		do{
			cin >> b;
			if (b < 0 || b > 10)
				cout << "nota invalida" << endl;
		}while(b < 0 || b > 10);

		cout << "media = " << fixed << setprecision(2) << (a + b) / 2 << endl;
		cout << "novo calculo (1-sim 2-nao)" << endl;
		cin >> x;
		if(x != 1 && x != 2)
		{
			cout << "novo calculo (1-sim 2-nao)" << endl;
			cin >> x;
		}
		if(x == 2) break;
	}while(x == 1);
	

	return 0;
}
*/