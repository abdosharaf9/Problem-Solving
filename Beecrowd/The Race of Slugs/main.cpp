#include <iostream>

using namespace std;

int main()
{
    int l, v[500];

    while(cin >> l)
    {
        if(l == EOF) {break;}

        for(int i = 0; i < l; i++)
        {
            cin >> v[i];
        }

        int maximum = v[0];

        for(int i = 1; i < l; i++)
        {
            if(v[i] > maximum)
            {
                maximum = v[i];
            }
        }

        if(maximum < 10) {cout << "1" << endl;}
        else if(maximum >= 10 && maximum < 20) {cout << "2" << endl;}
        else if(maximum >= 20) {cout << "3" << endl;}
    }


    return 0;
}
