#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	float a[101];

	for(int i=1;i<=100;i++)
	{
		cin >> a[i];

		if(a[i]<=10)
		{
			cout << "A[" << i << "] = " << fixed << setprecision(1) << a[i] <<endl;
		}
	}

	return 0;
}