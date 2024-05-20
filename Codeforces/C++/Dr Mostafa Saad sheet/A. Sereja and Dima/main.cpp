#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n, a = 0, b = 0; cin >> n;
    ll *arr = new ll[n];
    ll f = 0, l = n-1;
    for(ll i = 0; i < n; i++)
        cin >> arr[i];

    for(ll i = 0; i < n; i++)
    {
        if(i%2 == 0)
        {
            if(arr[f] > arr[l])
            {
                a+= arr[f];
                f++;
            }
            else
            {
                a += arr[l];
                l--;
            }
        }
        else
        {
            if(arr[f] > arr[l])
            {
                b+= arr[f];
                f++;
            }
            else
            {
                b += arr[l];
                l--;
            }
        }
    }
    cout << a << " " << b;
    delete []arr;
    return 0;
}
