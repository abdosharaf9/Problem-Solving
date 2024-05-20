#include <iostream>

using namespace std;

int main()
{
    int c, n;
    cin >> c;

    for(int i = 0; i < c; i++)
    {
        cin >> n;

        if(n%2 == 0)
            cout << "0" << endl;
        else
            cout << "1" << endl;
    }

    return 0;
}
