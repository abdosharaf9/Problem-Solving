#include <iostream>

using namespace std;

int main()
{

    int n, count = 1, x, min;
    cin >> n;

    cin >> x;
    min = x;

    for(int i = 1; i < n; i++)
    {
        cin >> x;

        if(min > x)
        {
            min = x;
            count++;
        }
    }

    cout << count << endl;

    return 0;
}
