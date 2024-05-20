#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    char x; cin >> x; ((x >= 65 && x <= 90) || (x >= 97 && x <= 122)) ? cout << "Alphabet" : cout << "Not alphabet";
    return 0;
}
