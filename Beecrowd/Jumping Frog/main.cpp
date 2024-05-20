#include <iostream>

using namespace std;

int main()
{
    int p,N;
    cin >> p >> N;

    int n[N];
    cin >> n[0];

    for(int i = 1; i < N; i++)
    {
        cin >> n[i];
        if(abs(n[i] - n[i-1]) > p)
        {
            cout << "GAME OVER" << endl;
            return 0;
        }
    }

    cout << "YOU WIN" << endl;

    return 0;
}
