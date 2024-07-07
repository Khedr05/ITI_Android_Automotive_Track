#include <iostream>
using namespace std;

int main(void)
{
    int userInput = 0;
    int hours = 0, minutes = 0, seconds = 0;

    cout << "Input Seconds : ";
    cin >> userInput;

    hours = userInput / 3600;
    minutes = (userInput % 3600) / 60;
    seconds = userInput % 60;

    cout << userInput << " seconds is equal to " << "H : M : S " << hours << ":" << minutes << ":" << seconds << endl;


}