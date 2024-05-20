#include <iostream>
using namespace std;
int main()
{
	int inter, gremio, inter_sum = 0, gremio_sum = 0, empates_sum = 0, x = 0, z = 1;
	while (z == 1)
	{
		cin >> inter >> gremio;

		if (inter > gremio)
		{
			inter_sum += 1;
		}
		if (gremio > inter)
		{
			gremio_sum += 1;
		}
		if (gremio == inter)
		{
			empates_sum += 1;
		}

		do{
			cout << "Novo grenal (1-sim 2-nao)" << endl;
			cin >> z;
		}while (z != 1 && z != 2);

		x++;
	}


	cout << x << " grenais" << endl;
	cout << "Inter:" << inter_sum << endl;
	cout << "Gremio:" << gremio_sum << endl;
	cout << "Empates:" << empates_sum << endl;

	if (inter_sum > gremio_sum)
		cout << "Inter venceu mais" << endl;
	else if (gremio_sum > inter_sum)
		cout << "Gremio venceu mais" << endl;
	else if (inter_sum == gremio_sum)
		cout << "Não houve vencedor" << endl;
	return 0;
}