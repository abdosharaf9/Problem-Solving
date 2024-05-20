#include <iostream>
#include <string>

using namespace std;
int main()
{
    int x, count = 0;
    string result;
    cin >> x;

    while(x > 0)
    {
        if(x < 16)
        {
            result[count] = x;
            x = 0;
        }

        else
        {
            result[count] = x % 16;
            x = x - result[count];

            if(result[count] == 10)
                result[count] == 'A';
            else if(result[count] == 11)
                result[count] == 'B';
            else if(result[count] == 12)
                result[count] == 'C';
            else if(result[count] == 13)
                result[count] == 'D';
            else if(result[count] == 14)
                result[count] == 'E';
            else if(result[count] == 15)
                result[count] == 'F';

            x = x / 16;
            count++;
        }
    }

    cout << result << endl;

    return 0;
}



    */


#include <bits/stdc++.h>

using namespace std;

char r[10],d[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
int n,k;

int main(){
    scanf("%d",&n);
    while(n){
        r[k++] = d[n%16];
        n /= 16;
    }
    while(k--) printf("%c",r[k]);
    printf("n");
    return 0;
}

