#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	float A, B, C;
	cin >> A >> B >> C;
	cout << "TRIANGULO: " << fixed << setprecision(3) << (0.5 * A * C) << endl;
	cout << "CIRCULO: " << fixed << setprecision(3) << (3.14159 * C * C) << endl;
	cout << "TRAPEZIO: " << fixed << setprecision(3) << (0.5 * (A + B) * C) << endl;
	cout << "QUADRADO: " << fixed << setprecision(3) << (B * B) << endl;
	cout << "RETANGULO: " << fixed << setprecision(3) << (A * B) << endl;

	return 0;
}