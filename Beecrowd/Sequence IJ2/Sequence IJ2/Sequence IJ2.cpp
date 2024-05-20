#include <iostream>
using namespace std;
int main()
{
	/*for (int i = 1; i <= 9; i+= 2)
		for(int j = 7; j >= 5; j--)
			cout << "I = " << i << " J = " << j << endl;*/

	for (int i = 1; i <= 9; i+= 2){
		cout << "I = " << i << " J = 7" << endl;
		cout << "I = " << i << " J = 6" << endl;
		cout << "I = " << i << " J = 5" << endl;
	}
	return 0;
}