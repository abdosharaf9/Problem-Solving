#include <iostream>
using namespace std;
int main()
{
	int a, b, c, d;
	int dif;
    cin >> a >> b >> c >> d;

    dif = ((c * 60) + d) - ((a * 60) + b);
    if(dif <= 0)
		dif += 24 * 60;

    cout << "O JOGO DUROU " << dif / 60 << " HORA(S) E " << dif % 60 <<" MINUTO(S) \n";

	return 0;
}

/*#include <iostream>
using namespace std;
int main(){
    int a, b, c, d;
    
    cin >> a >> b >> c >> d;
    
    int inicio = a*60 + b;
    int final = c*60 + d;
    int duracao = 0;
    
    if(a <= c)
    {
        duracao = final - inicio;
        if(duracao == 0)
            cout <<"O JOGO DUROU "<< 24 << " HORA(S) E " << duracao % 60 << " MINUTO(S)n" << endl;
        else
            cout <<"O JOGO DUROU " << (duracao - duracao%60)/60 << " HORA(S) E " << duracao%60 << " MINUTO(S)n" << endl;
    }
    else
    {
          duracao = (24*60 - inicio) + final;
          cout <<"O JOGO DUROU " << (duracao - duracao%60)/60 << " HORA(S) E " << duracao%60 << " MINUTO(S)n" << endl;
    }
    
    return 0;
    
}*/