#include <iostream>
using namespace std;
int main()
{
	int password;

	while (true)
	{
		cin >> password;

		if (password != 2002)
			cout << "Senha Invalida" << endl;
		if (password == 2002)
		{
			cout << "Acesso Permitido" << endl;
			break;
		}
	}

	return 0;
}