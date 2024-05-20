#include <iostream>
#include <math.h>
using namespace std;
int main()
{
    double fg, m, d, g;
    cin >> fg >> m >> d;
    g = fg / m;
    cout << sqrt(d / (0.5 * g));
    return 0;
}

/*
Using the following equations Fg = MG and D = ViT+½GT^2.

Note:-
If you are getting confused by the Vi part here is a hint:
When an object is at rest, meaning not moving, what is its speed.

Inputs:
500 -> Fg
70  -> M
10  -> D
and Vi will be 0
we need T.

Outputs:
It will take the object 1.7 seconds to fall 10.0 meters

Fg = MG -> G = Fg/M
D = ViT+½GT^2 -> D = 0.5 * (G * T * T)
(T * T) = D / (0.5 * G) -> T = sqrt(D / (0.5 * G))
*/
