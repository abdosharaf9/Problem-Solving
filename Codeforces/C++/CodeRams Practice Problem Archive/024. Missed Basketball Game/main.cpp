#include <iostream>
#include <string>
using namespace std;
typedef long long ll;
int main()
{
    string s1, s2; cin >> s1 >> s2;
    ll baskets1, baskets2; cin >> baskets1 >> baskets2;
    ll three1, three2; cin >> three1 >> three2;
    ll free1, free2; cin >> free1 >> free2;
    ll t1, t2;
    t1 = (free1 * 1) + (three1 * 3) + ((baskets1 - three1) * 2);
    t2 = (free2 * 1) + (three2 * 3) + ((baskets2 - three2) * 2);
    (t1 > t2)? cout << s1 : cout << s2;
    return 0;
}

/*
Three pointers = 3 p
Regular Basket = 2 p
Free Throw     = 1 p

Regular baskets = baskets - three pointers

Total = (Free Throw * 1) + (Three pointers * 3) + ((baskets - Three pointers) * 2)
*/
