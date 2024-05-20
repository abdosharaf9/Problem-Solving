#include <iostream>

using namespace std;

int main()
{
    int n,t,time;
    cin >> n;

    for(int i = 0; i < n; i++)
    {
        cin >> t;
        time = 2015 - t;
        if(time < 1)
            cout << 1 - time << " A.C." << endl;
        else
            cout << time << " D.C." << endl;
    }
    return 0;
}
