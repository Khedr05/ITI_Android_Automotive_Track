#include <iostream>

template <typename T, typename T2>
class pair
{
private:
    T key;
    T2 value;



public:
    pair(T Copykey, T2 copyVal)
    {
        key = Copykey;
        value = copyVal;
    }

    void getKey(T* copyKey)
    {
        *copyKey = key;
    }
    void getVal(T2* copyVal)
    {
        *copyVal = value;
    }
    void setKey(T copyKey)
    {
        key = copyKey;
    }
    void setVal(T2 copyVal)
    {
        value = copyVal;
    }
    void setPair(T copyKey, T2 copyVal)
    {
        key = copyKey;
        value = copyVal;
    }
    void printPair(void)
    {
        std::cout << "Printing Pair" << std::endl;
        std::cout << "Key is : " << key << std::endl;
        std::cout << "Value is : " << value << std::endl;
    }
};


int main(void)
{
    std::string key;
    int val;
    pair p(std::string("year"), 2000);
    p.printPair();
    p.getKey(&key);
    p.getVal(&val);
    std::cout << "Printing Pair" << std::endl;
    std::cout << "Key is : " << key << std::endl;
    std::cout << "Value is : " << val << std::endl;
    p.setKey("day");
    p.setVal(5);
    p.printPair();
    p.setPair("month", 1);
    p.printPair();


}