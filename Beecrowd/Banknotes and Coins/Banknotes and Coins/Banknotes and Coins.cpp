#include <iostream>
using namespace std;
int main()
{
	/*double n100, n50, n20, n10, n5, n2;
    double m1, m50, m25, m10, m05, m01;
    double n;

    cin >> n;
    int notas = n;
    int moedas = (n - notas) * 100;

    if((moedas * 1000) % 10 == 9){
        moedas++;
    }


    n100 = notas/100;
    notas = notas%100;
    n50 = notas/50;
    notas = notas%50;
    n20 = notas/20;
    notas = notas%20;
    n10 = notas/10;
    notas = notas%10;
    n5 = notas/5;
    notas = notas%5;
    n2 = notas/2;
    notas = notas%2;

    m1 = notas/1;
    notas = notas%1;
    m50 = moedas/50;
    moedas = moedas%50;
    m25 = moedas/25;
    moedas = moedas%25;
    m10 = moedas/10;
    moedas = moedas%10;
    m05 = moedas/5;
    moedas = moedas%5;
    m01 = moedas/1;

    cout << "NOTAS:" << endl; 
    cout << n100 << " nota(s) de R$ 100.00" << endl;
    cout << n50 << " nota(s) de R$ 50.00" << endl;
    cout << n20 << " nota(s) de R$ 20.00" << endl;
    cout << n10 << " nota(s) de R$ 10.00" << endl;
    cout << n5 << " nota(s) de R$ 5.00" << endl;
    cout << n2 << " nota(s) de R$ 2.00" << endl;
    cout << "MOEDAS:" << endl;
    cout << m1 << " moeda(s) de R$ 1.00" << endl;
    cout << m50 << " moeda(s) de R$ 0.50" << endl;
    cout << m25 << " moeda(s) de R$ 0.25" << endl;
    cout << m10 << " moeda(s) de R$ 0.10" << endl;
    cout << m05 << " moeda(s) de R$ 0.05" << endl;
    cout << m01 << " moeda(s) de R$ 0.01" << endl;*/

	/*double N;
    int inteiro, aux, aux1;

    while(cin >> N){

    inteiro = N;
    N = 100*N;
    aux1 = N;


    cout << "NOTAS:\n";
    cout << inteiro/100 << " nota(s) de R$ 100.00\n";
    aux = (inteiro%100);
    cout << aux/50 << " nota(s) de R$ 50.00\n";
    aux = (aux%50);
    cout << aux/20 << " nota(s) de R$ 20.00\n";
    aux = (aux%20);
    cout << aux/10 << " nota(s) de R$ 10.00\n";
    aux = (aux%10);
    cout << aux/5 << " nota(s) de R$ 5.00\n";
    aux = (aux%5);
    cout << aux/2 << " nota(s) de R$ 2.00\n";
    aux = (aux%2);
    cout << "MOEDAS:\n";
    cout << aux/1 << " moeda(s) de R$ 1.00\n";

    aux1 = aux1%100;
    cout <<  aux1/50 << " moeda(s) de R$ 0.50\n";
    aux1 = aux1%50;
    cout <<  aux1/25 << " moeda(s) de R$ 0.25\n";
    aux1 = aux1%25;
    cout <<  aux1/10 << " moeda(s) de R$ 0.10\n";
    aux1 = aux1%10;
    cout <<  aux1/5 << " moeda(s) de R$ 0.05\n";
    aux1 = aux1%5;
    cout <<  aux1/1 << " moeda(s) de R$ 0.01\n";
    }*/

	double n;
	int x, y ,z;
	cin >> n;
	x = n;
	n = n * 100;
	y = n;

	cout << "NOTAS:" << endl;

	cout << x / 100 << " nota(s) de R$ 100.00" << endl;
	z = x % 100;
	cout << z / 50 << " nota(s) de R$ 50.00" << endl;
	z = z % 50;
	cout << z / 20 << " nota(s) de R$ 20.00" << endl;
	z = z % 20;
	cout << z / 10 << " nota(s) de R$ 10.00" << endl;
	z = z % 10;
	cout << z / 5 << " nota(s) de R$ 5.00" << endl;
	z = z % 5;
	cout << z / 2 << " nota(s) de R$ 2.00" << endl;
	z = z % 2;

	cout << "MOEDAS:" << endl;
	cout << z / 1 << " moeda(s) de R$ 1.00" << endl;

	y = y % 100;
	cout << y / 50 << " moeda(s) de R$ 0.50" << endl;
	y = y % 50;
	cout << y / 25 << " moeda(s) de R$ 0.25" << endl;
	y = y % 25;
	cout << y / 10 << " moeda(s) de R$ 0.10" << endl;
	y = y % 10;
	cout << y / 5 << " moeda(s) de R$ 0.05" << endl;
	y = y % 5;
	cout << y / 1 << " moeda(s) de R$ 0.01" << endl;

	return 0;
}