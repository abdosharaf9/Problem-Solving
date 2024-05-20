#include <iostream>

using namespace std;

int main()
{
    int r1, r2, n;
    cin >> n;

    for(int i = 0; i < n; i++)
    {
        cin >> r1 >> r2;
        cout << r1 + r2 << endl;
    }

    return 0;
}
