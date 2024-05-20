#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n; cin >> n;
    if(n % 3 == 0 && n % 5 == 0) cout << "FizzBuzz";
    else if(n % 3 == 0) cout << "Fizz";
    else if(n % 5 == 0) cout << "Buzz";
    return 0;
}
