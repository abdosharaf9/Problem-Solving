#include <iostream>
#include <iomanip>
using namespace std;
int main(){
	float s = 1;
	int b = 2;
	for(int i = 3; i < 40; i++)
	{
		s += (float)i/(float)b;
		i++;
		b *= 2;
	}
	cout << fixed << setprecision(2) << s << endl;
	return 0;
}


/*#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	float s = 1, b = 2;
	for(int i = 3; i <= 39; ++i)
	{
		s+= (float)i/b;
		i++;
		b*=2;
	}
	cout << fixed << setprecision(2) << s << endl;

	return 0;
}*/