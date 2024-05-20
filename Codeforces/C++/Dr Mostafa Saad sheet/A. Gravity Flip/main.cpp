#include <iostream>
using namespace std;
typedef long long ll;
int main()
{
    ll n; cin >> n;
    ll *arr = new ll[n];
    for(ll i = 0; i < n; i++)
        cin >> arr[i];
    for(ll i = 0; i < n; i++)
    {
        for(ll j = 0; j < n - 1; j++)
            if(arr[j] > arr[j+1]) swap(arr[j], arr[j+1]);
    }
    for(ll i = 0; i < n; i++)
        cout << arr[i] << " ";
    delete []arr;
    return 0;
}
