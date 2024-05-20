// wrong answer test case 2
#include <iostream>
#include <string>
using namespace std;
typedef long long ll;

class Team
{
public:
    string name;
    ll pts = 0;
};

int main()
{
    ll n; cin >> n;
    Team t1, t2, t3, t4;
    char r;
    for(ll i =0; i <n; i++)
    {
        if(i == 0)
        {
            cin >> t1.name >> t2.name >> r;
            if(r == 'W') t1.pts += 3;
            else if(r == 'T') {t1.pts += 1; t2.pts += 1;}
            else if(r == 'L') t2.pts += 3;
        }
        else if(i == 1)
        {
            cin >> t3.name >> t4.name >> r;
            if(r == 'W') t3.pts += 3;
            else if(r == 'T') {t3.pts += 1; t4.pts += 1;}
            else if(r == 'L') t4.pts += 3;
        }
        else if(i == 2)
        {
            cin >> t1.name >> t4.name >> r;
            if(r == 'W') t1.pts += 3;
            else if(r == 'T') {t1.pts += 1; t4.pts += 1;}
            else if(r == 'L') t4.pts += 3;
        }
        else if(i == 3)
        {
            cin >> t3.name >> t2.name >> r;
            if(r == 'W') t3.pts += 3;
            else if(r == 'T') {t3.pts += 1; t2.pts += 1;}
            else if(r == 'L') t2.pts += 3;
        }
        else if(i == 4)
        {
            cin >> t1.name >> t3.name >> r;
            if(r == 'W') t1.pts += 3;
            else if(r == 'T') {t1.pts += 1; t3.pts += 1;}
            else if(r == 'L') t3.pts += 3;
        }
        else if(i == 5)
        {
            cin >> t2.name >> t4.name >> r;
            if(r == 'W') t2.pts += 3;
            else if(r == 'T') {t2.pts += 1; t4.pts += 1;}
            else if(r == 'L') t4.pts += 3;
        }
    }
    Team all[4] = {t1, t2, t3, t4};
    for(ll i = 0; i < 4; i++)
    {
        for(ll j = 0; j < 3; j++)
        {
            if(all[j].pts < all[j+1].pts)
            {
                swap(all[j].name, all[j+1].name);
                swap(all[j].pts, all[j+1].pts);
            }
        }
    }
    for(ll i = 0; i < 4; i++)
    {
        cout << all[i].name << " " << all[i].pts << "\n";
    }
    return 0;
}

/*
Input:-
t1      t2
Germany Portugal W
t3           t4
UnitedStates Ghana W

t1      t4
Germany Ghana T
t3           t2
UnitedStates Portugal T

t1      t3
Germany UnitedStates W
t2       t4
Portugal Ghana W


Output:-
Germany 7
Portugal 4
UnitedStates 4
Ghana 1
*/
/*
6
Germany Portugal L
UnitedStates Ghana T
Germany Ghana W
UnitedStates Portugal L
Germany UnitedStates T
Portugal Ghana T
*/
