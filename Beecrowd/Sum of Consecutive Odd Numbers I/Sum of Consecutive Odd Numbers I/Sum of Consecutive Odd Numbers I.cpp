#include <iostream>
using namespace std;
int main()
{
	int x,y,i,sum=0;
	cin >> x >> y;

    if(x % 2 != 0 && y % 2 != 0)
	{
       for(i = y + 2; i < x; i = i + 2)
       sum+=i;
	   cout << sum << endl;
    }
    if(x % 2 != 0 && y % 2 == 0)
	{
       for(i = y + 1; i < x; i = i + 2)
       sum+=i;
            cout << sum << endl;
    }
    if(x % 2 == 0 && y % 2 != 0)
	{
       for(i = y + 2;i < x;i = i + 2)
       sum+=i;
       cout << sum << endl;
    }
    if(x % 2 == 0 && y % 2 == 0)
	{
       for(i = y + 1; i < x; i = i + 2)
       sum+=i;
       cout << sum << endl;
    }

	return 0;
}