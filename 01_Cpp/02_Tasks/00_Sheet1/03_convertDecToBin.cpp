#include <iostream>
#include <math.h>
using namespace std;

int main(void)
{

    long long bin=0, dec=0, tempdec=0;
    int rem, place = 1;


    cout << "Enter any decimal number : ";
    cin >> dec;

    tempdec = dec;

    while(tempdec > 0)
    {
        rem = tempdec % 2;

        bin = (rem * place) + bin;

        tempdec /= 2;

        place *= 10;
    }

    cout << dec <<" in decimal -> is " << bin <<" in binary";

    return 0;
}