#include <iostream>
#include <string>
using namespace std;

int main()
{
    int c,n;
    string name;
    cin >> c;

    for(int i = 0; i < c; i++)
    {
        cin >> name >> n;

        if(name == "Thor")
            cout << "Y" << endl;
        else
            cout << "N" << endl;
    }


    return 0;
}
