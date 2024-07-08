#include <iostream>
#include <string>
#include <utility> 

class pair
{
private:
    std::string first;
    std::string second;



public:
    pair()
    {
        first = "";
        second = "";
    }

    pair(std::string firstElement, std::string secondElement)
    {
        first = firstElement;
        second = secondElement;
    }

    void getFirst(std::string* firstElement)
    {
        *firstElement = first;
    }
    void getSecond(std::string* secondElement)
    {
        *secondElement = second;
    }
    void setFirst(std::string firstElement)
    {
        first = firstElement;
    }
    void setSecond(std::string secondElement)
    {
        second = secondElement;
    }
    void setPair(std::string firstElement, std::string secondElement)
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
        std::swap(first, second);
    }
};


int main(void)
{
    pair p;
    std::string first, second;
    p.printPair();
    p.setFirst("cpp");
    p.setSecond("c");
    p.printPair();
    p.getFirst(&first);
    p.getSecond(&second);
    std::cout << "Printing Pair" << std::endl;
    std::cout << "First element is : " << first << std::endl;
    std::cout << "Second element is : " << second << std::endl;
    p.swapPair();
    p.printPair();
    p.setPair("java", "kotlin");
    p.printPair();


}