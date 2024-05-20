#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    char x; cin >> x;
    if(isalpha(x))
    {
        cout << "Alphabet ";
        if(isupper(x)) cout << "Upper ";
        else cout << "Lower ";
        if(x == 65 || x == 97 || x == 69 || x == 101 || x == 73 || x == 105 || x == 79 || x == 111 || x == 85 || x == 117) cout << "Vowel";
        else cout << "Consonant";
    }
    else if(isdigit(x)) cout << "Number";
    else cout << "Special";
    return 0;
}
