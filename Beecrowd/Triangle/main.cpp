#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int a[4];

    for(int i = 0; i < 4; i++)
        cin >> a[i];

    sort(a,a+4);

    if((a[0]+a[1]) > a[2])
        cout << "S" << endl;
    else if((a[0]+a[1]) > a[3])
        cout << "S" << endl;
    else if((a[1]+a[2]) > a[3])
        cout << "S" << endl;
    else
        cout << "N" << endl;

    return 0;
}
