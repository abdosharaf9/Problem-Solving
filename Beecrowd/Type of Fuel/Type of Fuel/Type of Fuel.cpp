#include <iostream>
using namespace std;
int main()
{
	int code = 0, alcohol = 0, gasoline = 0, diesel = 0;

	while (true)
	{
		cin >> code;
		if (code == 1) alcohol++;
		else if (code == 2) gasoline++;
		else if (code == 3) diesel++;
		else if (code == 4) break;
		else continue;
	}

	cout << "MUITO OBRIGADO" << endl;
	cout << "Alcool: " << alcohol << endl;
	cout << "Gasolina: " << gasoline << endl;
	cout << "Diesel: " << diesel << endl;

	return 0;
}

/*
#include <iostream>
using namespace std;
int main()
{
	int code = 0, alcohol = 0, gasoline = 0, diesel = 0;

	while (code != 4)
	{
		cin >> code;
		switch(code)
		{
		case 1:
			alcohol+= 1;
			break;
		case 2:
			gasoline+= 1;
			break;
		case 3:
			diesel+= 1;
			break;
		case 4:
			break;
		}
	}

	cout << "MUITO OBRIGADO" << endl;
	cout << "Alcool: " << alcohol << endl;
	cout << "Gasolina: " << gasoline << endl;
	cout << "Diesel: " << diesel << endl;

	return 0;
}
*/