#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
    int C;
    double M[12][12], soma = 0.0;
    char T;

    cin >> C;
    cin >> T;

    for(int i = 0; i <= 11; i++)
    {
        for(int j = 0; j <= 11; j++)
        {
            cin >> M[i][j];

            if(j == C)
            {
                soma+= M[i][j];
            }
        }
    }

    if(T == 'S')
    {
        cout << fixed << setprecision(1) << soma <<endl;
    }

    else if(T == 'M')
    {
        cout << fixed << setprecision(1) << soma/12.0 <<endl;
    }

    return 0;
}
