#include <iostream>
#include <string>

using namespace std;

int main()
{
    int t;
    string x,y;

    cin >> t;

    for (int i = 1; i <= t; i++)
    {
        cin >> x >> y ;

        if(x==y)
            cout << "Caso #" << i << ": De novo!" << endl;

        else if(x=="tesoura" && y=="papel")
            cout << "Caso #" << i <<": Bazinga!" << endl;

        else if(x=="papel" && y=="pedra")
            cout << "Caso #" << i <<": Bazinga!" << endl;

        else if(x=="pedra" && y=="lagarto")
            cout << "Caso #" << i <<": Bazinga!" << endl;

        else if(x=="lagarto" && y=="Spock")
            cout << "Caso #" << i <<": Bazinga!" << endl;

        else if(x=="Spock" && y=="tesoura")
            cout << "Caso #" << i <<": Bazinga!" << endl;

        else if(x=="tesoura" && y=="lagarto")
            cout << "Caso #" << i <<": Bazinga!" << endl;

        else if(x=="lagarto" && y=="papel")
            cout << "Caso #" << i <<": Bazinga!" << endl;

        else if(x=="papel" && y=="Spock")
            cout << "Caso #" << i <<": Bazinga!" << endl;

        else if(x=="Spock" && y=="pedra")
            cout << "Caso #" << i <<": Bazinga!" << endl;

        else if(x=="pedra" && y=="tesoura")
            cout << "Caso #" << i <<": Bazinga!" << endl;

        else
            cout << "Caso #" << i << ": Raj trapaceou!" << endl;
    }

    return 0;
}
