#include <iostream>
using namespace std;
int main()
{
	int n, small = 1000, pos = 0;
	cin >> n;

	int N[n];

	for(int i = 0; i < n; i++)
	{
		cin >> N[i];
		if(N[i] < small)
		{
			small = N[i];
			pos = i;
		}
	}

	cout << "Menor valor: " << small << endl;
	cout << "Posicao: " << pos << endl;

	return 0;
}