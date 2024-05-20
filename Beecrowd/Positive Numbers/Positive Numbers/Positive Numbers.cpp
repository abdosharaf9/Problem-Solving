#include <iostream>
using namespace std;
int main()
{
	float n, aux = 0, avg = 0;
	int sum = 0;
	for (int i = 0; i < 6; i++)
	{
		cin >> n;
		if (n > 0)
		{
			sum++ ;
			aux += n;
			avg = aux / sum;
		}
	}
	cout << sum << " valores positivos" << endl;
	cout << avg << endl;

	return 0;
}