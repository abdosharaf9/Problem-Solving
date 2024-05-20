#include <iostream>

using namespace std;

int main()
{
    cout << "Hello world!" << endl;
    return 0;
}
/*
#include <stdio.h>

int main(int argc, char const *argv[]) {
    long double n;
    scanf("%LE", &n);
    printf("%+.4LEn", n);
    return 0;
}#include <stdio.h>

int main(int argc, char const *argv[]) {
    long double n;
    scanf("%LE", &n);
    printf("%+.4LEn", n);
    return 0;
}
*/

/*
#include <stdio.h>
int main()
{
    long double X;
    char s[120];
    scanf("%LE", &X);
    sprintf(s,"%LE", X);
    if(s[0] != '-') printf("+");
    printf("%.4LE\n", X);
    return 0;
}
*/
