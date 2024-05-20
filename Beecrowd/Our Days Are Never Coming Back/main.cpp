#include <iostream>
#include <string>
using namespace std;

int main()
{

    string x = "LIFE IS NOT A PROBLEM TO BE SOLVED";
    int n;
    cin >> n;

    for(int i = 0; i < n; i++)
    {
        cout << x[i];
    }

    cout << endl;
    return 0;
}
