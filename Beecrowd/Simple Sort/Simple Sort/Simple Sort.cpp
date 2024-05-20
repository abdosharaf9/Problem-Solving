#include <iostream>
using namespace std;
int main()
{
	int arr[3] , arr2[3], temp;

	for (int i = 0; i < 3; i++) {
		cin >> arr[i];
		arr2[i] = arr[i];
	}

	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < i; j++) {
			if (arr[j] > arr[i]) {
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
	}

	cout << endl;
	for (int i = 0; i < 3; i++) {
		cout << arr[i] << endl;
	}

	cout << "\n";

	for (int i = 0; i < 3; i++) {
		cout << arr2[i] << endl;
	}

	return 0;
}