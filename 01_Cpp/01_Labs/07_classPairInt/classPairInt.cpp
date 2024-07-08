#include <iostream>


class pair
{
private:
    int first;
    int second;



public:
    pair()
    {
        first = 0;
        second = 0;
    }

    pair(int firstElement, int secondElement)
    {
        first = firstElement;
        second = secondElement;
    }

    void getFirst(int* firstElement)
    {
        *firstElement = first;
    }
    void getSecond(int* secondElement)
    {
        *secondElement = second;
    }
    void setFirst(int firstElement)
    {
        first = firstElement;
    }
    void setSecond(int secondElement)
    {
        second = secondElement;
    }
    void setPair(int firstElement, int secondElement)
    {
        first = firstElement;
        second = secondElement;
    }
    void printPair(void)
    {
        std::cout << "Printing Pair" << std::endl;
        std::cout << "First element is : " << first << std::endl;
        std::cout << "Second element is : " << second << std::endl;
    }
    void swapPair(void)
    {
        first = first + second;
        second = first - second;
        first = first - second;
    }
};


int main(void)
{
    pair p;
    int first, second;
    p.printPair();
    p.setFirst(5);
    p.setSecond(10);
    p.printPair();
    p.getFirst(&first);
    p.getSecond(&second);
    std::cout << "Printing Pair" << std::endl;
    std::cout << "First element is : " << first << std::endl;
    std::cout << "Second element is : " << second << std::endl;
    p.swapPair();
    p.printPair();
    p.setPair(15, 20);
    p.printPair();


}