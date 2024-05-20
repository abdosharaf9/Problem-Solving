#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	int l;
	char t;
	double M[12][12], sum = 0;

	cin >>l >> t;

	for(int i = 0; i < 12; i++)
	{
		for(int j = 0; j < 12; j++)
		{
			cin >> M[i][j];
			if(i == l)
				sum+= M[i][j];
		}
	}

	if(t == 'S')
		cout << fixed << setprecision(1) << sum << endl;
	else if(t == 'M')
		cout << fixed << setprecision(1) << sum/12.0 << endl;

	return 0;
}