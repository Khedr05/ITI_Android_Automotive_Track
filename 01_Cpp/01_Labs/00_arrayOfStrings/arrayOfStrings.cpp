#include <iostream>
#include <cstring>
using namespace std;

void arrOfStrings(int noOfStrings) 
{
    char **arr = (char **)malloc(noOfStrings * sizeof(char *)); 

    cout << "Enter " << noOfStrings << " strings:" << endl;
    cin.ignore(); 

    const int maxStrLen = 20;
    for (int i = 0; i < noOfStrings; i++) 
    {
        arr[i] = (char *)malloc(maxStrLen * sizeof(char)); 

        cout << "String " << i + 1 << ": ";
        string input;
        getline(cin, input);

        strncpy(arr[i], input.c_str(), maxStrLen - 1);
        
        arr[i][maxStrLen - 1] = '\0'; 
    }

    cout << "\nStrings entered:" << endl;
    for (int i = 0; i < noOfStrings; i++) 
    {
        cout << "arr[" << i << "]: " << arr[i] << endl;
    }

    for (int i = 0; i < noOfStrings; i++) 
    {
        free(arr[i]); 
    }
    free(arr); 
}

int main() 
{
    int noOfStrings;

    cout << "Enter the number of strings: ";
    cin >> noOfStrings;

    arrOfStrings(noOfStrings);

    return 0;
}
