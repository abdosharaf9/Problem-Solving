#include <iostream>

using namespace std;

int main()
{
    int a,b,c,x,y;
    cin >> a >> b >> c;

    if(a > b)
        x = a - b;
    if(b > a)
        x = b - a;
    if(b > c)
        y = b - c;
    if(c > b)
        y = c - b;

    if(a == b) //first equal second
    {
        if(c < b) //dec from 2 to 3
        {
            cout << ":(" << endl;
        }

        if(c > b) //inc from 2 to 3
        {
            cout << ":)" << endl;
        }
    }

    else if(a < b) //inc from 1 to 2
    {
        if(b > c) //dec from 2 to 3
        {
            cout << ":(" << endl;
        }

        if(b < c && y < x) //inc from 2 to 3 but smaller than from 1 to 2
        {
            cout << ":(" << endl;
        }

        if(b < c && y > x) //inc from 2 to 3 but bigger than from 1 to 2
        {
            cout << ":)" << endl;
        }

    }

    else if(a > b) //dec from 1 to 2
    {
        if(c > b) //inc from 2 to 3
        {
            cout << ":)" << endl;
        }

        if(c < b && y < x) //dec from 2 to 3 but smaller than from 1 to 2
        {
            cout << ":)" << endl;
        }

        if(c < b && y > x) //dec from 2 to 3 but bigger than from 1 to 2
        {
            cout << ":(" << endl;
        }
    }


    return 0;
}


/*

#include<bits/stdc++.h>
using namespace std;
int main()
{
       int a,b,c;
       cin>>a>>b>>c;
       if(b>a&&c<=b)
             printf(":(\n");
       else if(b>a&&c>b&&(c-b)<(b-a))
             printf(":(\n");
       else if(b>a&&c>b&&(c-b)>=(b-a))
              printf(":)\n");
      else if(b<a&&c<b&&(b-c)<(a-b))
              printf(":)\n");
      else if(b<a&&c<b&&(b-c)>=(a-b))
              printf(":(\n");
      else if((a==b)&&c>b)
              printf(":)\n");
       else if((a==b)&&c<b)
              printf(":(\n");
       else if(b<a&&c>=b)
             printf(":)\n");
       else
             printf(":(\n");
return 0;
}


*/
