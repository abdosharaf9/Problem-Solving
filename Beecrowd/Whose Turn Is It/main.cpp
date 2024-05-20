#include <iostream>
#include <string>
using namespace std;

int main()
{
    int qt, n, m, sum = 0;
    string name1, name2, c1, c2;
    cin >> qt;

    for(int i = 0; i < qt; i++)
    {
        cin >> name1 >> c1 >> name2 >> c2 >> n >> m;
        sum = n + m;

        if(sum%2 == 0)
        {
            if(c1 == "PAR")
                cout << name1 << endl;
            else if(c2 == "PAR")
                cout << name2 << endl;
        }

        else
        {
            if(c1 == "IMPAR")
                cout << name1 << endl;
            else if(c2 == "IMPAR")
                cout << name2 << endl;
        }
    }


    return 0;
}
