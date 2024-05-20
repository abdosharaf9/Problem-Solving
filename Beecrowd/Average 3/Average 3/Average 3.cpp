#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	float n1, n2, n3, n4, media = 0;
	cin >> n1 >> n2 >> n3 >> n4;
	media = ((n1 * 2) + (n2 * 3) + (n3 * 4) + (n4 * 1)) / (10);
	cout << "Media: " << fixed << setprecision(1) << media << endl;
	
	if(media >= 7.0)
		cout << "Aluno aprovado." << endl;
	else if (media >= 5.0 && media <= 6.9)
	{
		cout << "Aluno em exame." << endl;
		float n5;
		cin >> n5;
		cout << "Nota do exame: " << n5 << endl;
		media = (n5 + (((n1 * 2) + (n2 * 3) + (n3 * 4) + (n4 * 1)) / (10))) / 2;
		cout << "Aluno aprovado." << endl;
		cout << "Media final: " << fixed << setprecision(1) << media << endl;
	}
	else if (media < 5.0)
		cout << "Aluno reprovado." << endl;


	return 0;
}