#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
    char O;
    double M[12][12], soma = 0.0;

    cin >> O;

    for(int i = 0; i<= 11; i++)
    {
        for(int j = 0; j<= 11; j++)
        {
            cin >> M[i][j];

            if(j < i)
            {
                soma+= M[i][j];
            }
        }
    }

    if(O == 'S')
    {
        cout << fixed << setprecision(1) << soma <<endl;
    }

    else if(O == 'M')
    {
        cout << fixed << setprecision(1) << soma/66.0 <<endl;
    }

    return 0;
}
