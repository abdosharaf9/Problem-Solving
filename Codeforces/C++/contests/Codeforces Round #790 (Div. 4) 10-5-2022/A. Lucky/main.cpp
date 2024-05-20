#include <iostream>
#include <string>
using namespace std;
int main() {
    string num;
    int t;
    cin >> t;
    while(t--) {
        cin >> num;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < num.size(); i++) {
            if (i < 3) {
                sum1 += (int)num[i] - '0';
            }
            else {
                sum2 += (int)num[i] - '0';
            }
        }
        if (sum1 == sum2) {
            cout << "YES" << endl;
        }
        else {
            cout << "NO" << endl;
        }
    }


}
