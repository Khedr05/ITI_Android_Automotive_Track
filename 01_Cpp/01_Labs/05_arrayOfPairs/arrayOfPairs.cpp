#include <iostream>
#include <utility> 



namespace nsArrayPair
{
    std::pair<int,int>* createArray(int size)
    {
        std::pair<int, int>* ptr = new std::pair<int, int>[size];
        return ptr;
    }


    void deleteArray(std::pair<int,int>* ptr)
    {
        delete [] ptr;
    }

    void setPair(std::pair<int,int> *ptr,int first,int second)
    {
        ptr->first = first;
        ptr->second = second;
    }

    void getPair(std::pair<int,int> *ptr,int *first,int *second)
    {
        *first = ptr->first;
        *second = ptr->second;
    }

    void printPair(std::pair<int,int> *ptr)
    {
        std::cout<< "Print Pair "<<std::endl;
        std::cout << "First Element : "<<ptr->first << std::endl;
        std::cout << "Second Element : "<<ptr->second << std::endl;
    }

}



int main(void)
{
    std::pair<int,int> p1;
    int first,second;
    nsArrayPair::createArray(2);
    nsArrayPair::setPair(&p1,5,3);
    nsArrayPair::getPair(&p1,&first,&second);
    std::cout << "First Element : "<<first << std::endl;
    std::cout << "Second Element : "<<second << std::endl;
    nsArrayPair::printPair(&p1);
    nsArrayPair::deleteArray(&p1);
}