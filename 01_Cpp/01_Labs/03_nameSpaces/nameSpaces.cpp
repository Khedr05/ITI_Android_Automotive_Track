#include <iostream>
#include <cstring>
#include<cmath>


namespace nsMath
{
    void print(double num)
    {
        std::cout << (sqrt(num));
    }
}

namespace nsString
{
    void print(std::string str)
    {
        
        for(int i=0;i<str.length();i++)
        {
            if(islower(str[i]))
            {
                str[i] = (toupper(str[i]));
            }
            else
            {
                str[i] = (tolower(str[i]));
            } 
        }
        std::cout << str << std::endl;
    }
}

namespace nsArray
{
    void print(int *arr , int size)
    {
        for(int i=size-1;i>=0;i--)
        {
            std::cout << arr[i] << " ";
        }
        std::cout<<std::endl;
    }
}

int main(void)
{
    nsMath::print(4);
    std::cout << std::endl;
    nsString::print("SHERIF");
    nsString::print("sherif");
    int arr[5] = {1,2,3,4,5};
    nsArray::print(arr , 5);
}