// Problem Link: https://codeforces.com/problemset/problem/228/A

#include <iostream>
#include <algorithm>
using namespace std;
int main()
{
    long long mas[4], e = 3;

    for (int i = 0; i < 4; i++)
        cin >> mas[i];

    sort(mas, mas + 4);

    for (int i = 0; i < 3; i++)
        if (mas[i] != mas[i + 1]) e--;

    cout << e;
    return 0;
}
//wrong one
/*#include <iostream>
using namespace std;
int main()
{
    long long s[4],n = 0;
    for(int i = 0; i < 4; i++)
    {
        cin >> s[i];
    }
    for(int i = 1; i < 4; i++)
    {
        if(s[0] == s[i]) n++;
    }
    for(int i = 2; i < 4; i++)
    {
        if(s[1] == s[i]) n++;
    }
    for(int i = 3; i < 4; i++)
    {
        if(s[2] == s[i]) n++;
    }
    cout << n;
    return 0;
}
*/
