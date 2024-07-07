#include <iostream>
#include <math.h>
using namespace std;

#define BASE 2

int main(void)
{

    long long bin=0, dec=0, tempBinary=0;
    int itrator = 0;

    cout << "Enter any binary number : ";
    cin >> bin;

    tempBinary = bin;

    while(tempBinary!=0)
    {
        if(tempBinary % 10 == 1)
        {
            dec += pow(BASE, itrator);
        }

        itrator++;
        tempBinary /= 10;
    }

    cout << bin <<" binary -> is "<<dec <<" in decimal";

    return 0;
}