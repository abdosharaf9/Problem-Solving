#include <iostream>
#include <string>
using namespace std;

int main()
{
    string x;
    int result = 0, count = 1;

    while(count <= 3)
    {
        getline(cin ,x);

        if(x[0] == 'c')
        {
            cout << result << endl;
            result = 0;
            count++;
        }

        else
        {
            if(x == "---")
                result+= 0;
            else if(x == "--*")
                result+= 1;
            else if(x == "-*-")
                result+= 2;
            else if(x == "-**")
                result+= 3;
            else if(x == "*--")
                result+= 4;
            else if(x == "*-*")
                result+= 5;
            else if(x == "**-")
                result+= 6;
            else if(x == "***")
                result+= 7;
        }
    }

    return 0;
}
