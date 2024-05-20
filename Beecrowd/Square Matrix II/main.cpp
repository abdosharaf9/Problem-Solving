#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

int main()
{
    int N;
    while(cin >> N && N!=0)
    {
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if(j == 0)
                    cout << setw(3) << abs(j-i)+1;
                else
                    cout << " " << setw(3) << abs(j-i)+1;
            }
            cout << endl;
        }
        cout << endl;
    }

    return 0;
}


/*#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

int main(int argc, const char * argv[])
{
    int n, i, j;

    while(cin >> n && n != 0){

        for(i = 0; i < n; i++) {
            for(j = 0; j < n; j++)
                if(j == 0)
                    cout << setw(3) << abs(j-i)+1;
                else
                    cout << " " << setw(3) << abs(j-i)+1;

            cout << endl;
        }

        cout << endl;
    }

    return 0;

}*/
