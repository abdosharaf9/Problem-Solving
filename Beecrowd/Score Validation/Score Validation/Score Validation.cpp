#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	float x, y;

	do{
		cin >> x;
		if (x < 0 || x > 10)
			cout << "nota invalida" << endl;
	}while(x < 0 || x > 10);

	do{
		cin >> y;
		if (y < 0 || y > 10)
			cout << "nota invalida" << endl;
	}while(y < 0 || y > 10);

	cout << "media = " << fixed << setprecision(2) << (x + y) / 2 << endl;

	return 0;
}

/*
#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	float x, y;

	cin >> x;
	if(x < 0 || x > 10)
	{
		cout << "nota invalida" << endl;
		cin >> x;
	}

	cin >> y;
	if(y < 0 || y > 10)
	{
		cout << "nota invalida" << endl;
		cin >> y;
	}

	cout << "media = " << fixed << setprecision(2) << (x + y) / 2 << endl;

	return 0;
}
*/