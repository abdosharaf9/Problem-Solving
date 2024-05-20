#include <iostream>
#include <string>
using namespace std;
int main()
{
	string c;
	cin >> c;

	if (c == "vertebrado")
	{
		cin >> c;
		if (c == "ave")
		{
			cin >> c;
			if (c == "carnivoro")
				cout << "aguia" << endl;
			else if (c == "onivoro")
				cout << "pomba" << endl;
		}

		else if (c == "mamifero")
		{
			cin >> c;
			if (c == "onivoro")
				cout << "homem" << endl;
			else if (c == "herbivoro")
				cout << "vaca" << endl;
		}
	}

	else if (c == "invertebrado")
	{
		cin >> c;
		if (c == "inseto")
		{
			cin >> c;
			if (c == "hematofago")
				cout << "pulga" << endl;
			else if (c == "herbivoro")
				cout << "lagarta" << endl;

		}
		else if (c == "anelideo")
		{
			cin >> c;
			if (c == "hematofago")
				cout << "sanguessuga" << endl;
			else if (c == "onivoro")
				cout << "minhoca" << endl;
		}
	}


	return 0;
}