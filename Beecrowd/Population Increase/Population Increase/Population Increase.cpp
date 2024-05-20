#include <iostream>
using namespace std;
int main()
{
	long t, PA, PB;
	int time = 0, sec = 0;
	double GA, GB;

	cin >> t;

	for(int i = 0; i < t; i++)
	{
		cin >> PA >> PB >> GA >> GB;

		while(PA <= PB)
		{
			PA+= PA*(GA/100);
			PB+= PB*(GB/100);
			time++;

			if(time > 100)
			{
				sec = 1;
				break;
			}
		}
		
		if(sec == 1)
			cout << "Mais de 1 seculo." << endl;
		else
			cout << time << " anos." << endl;
		time = 0;
		sec = 0;
	}

	return 0;
}