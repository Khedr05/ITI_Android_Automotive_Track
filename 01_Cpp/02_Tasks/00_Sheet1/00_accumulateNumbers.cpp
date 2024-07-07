#include <iostream>
using namespace std;

int main(void)
{
    int userInput = 0;
    int res = 0;

    while(1)
    {
        cout << "Please Enter Number : ";
        cin >> userInput;

        if(userInput == 0)
        {
            cout <<"Result is : " << res;
            break;
        }
        else
        {
            res += userInput;
        }

    }
}