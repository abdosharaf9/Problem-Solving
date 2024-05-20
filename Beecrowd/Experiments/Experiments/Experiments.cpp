#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	int n, amount, c_sum = 0, r_sum = 0, s_sum = 0;
	float total = 0;
	char animal;
	cin >> n;

	for(int i = 0; i < n; ++i)
	{
		cin >> amount;
		cin >> animal;
		if (animal == 'C')
			c_sum += amount;
		else if (animal == 'R')
			r_sum += amount;
		else if (animal == 'S')
			s_sum += amount;
	}

	total = c_sum + s_sum + r_sum;

	cout << "Total : " << total << " cobaias" << endl;
	
	cout << "Total de coelhos: " << c_sum << endl;
	cout << "Total de ratos: " << r_sum << endl;
	cout << "Total de sapos: " << s_sum << endl;

	cout << "Percentual de coelhos: " << fixed << setprecision(2) << (c_sum / total) * 100.0 << " %" << endl;
	cout << "Percentual de ratos: " << fixed << setprecision(2) << (r_sum / total) * 100.0 << " %" << endl;
	cout << "Percentual de sapos: " << fixed << setprecision(2) << (s_sum / total) * 100.0 << " %" << endl;
	
	return 0;
}