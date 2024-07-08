#include <iostream>

enum class Datatype
{
    INT,
    DOUBLE,
    CHAR
};

struct Data
{
    void* ptr;
    Datatype type;
};

class vPtrArray
{
private:
    Data* dataArray;
    int size;

public:
    vPtrArray(int arraySize)
    {
        size = arraySize;
        dataArray = new Data[size];
    }

    ~vPtrArray()
    {
        delete[] dataArray;
    }

    void SetVal(void* ptrVal, int index, Datatype varType)
    {
        dataArray[index].ptr = ptrVal;
        dataArray[index].type = varType;
    }

    void* getVal(int index)
    {
        return dataArray[index].ptr;
    }

    Datatype getType(int index)
    {
        return dataArray[index].type;
    }

    int getSize(void)
    {
        return size;
    }

    void printArray()
    {
        for (int i = 0; i < size; i++)
        {
            switch (dataArray[i].type)
            {
            case Datatype::INT:
                std::cout << "Value at index " << i << " : " << *static_cast<int*>(dataArray[i].ptr) << " its data type is : int" << std::endl;
                break;
            case Datatype::DOUBLE:
                std::cout << "Value at index " << i << " : " << *static_cast<double*>(dataArray[i].ptr) << " its data type is : double" << std::endl;
                break;
            case Datatype::CHAR:
                std::cout << "Value at index " << i << " : " << *static_cast<char*>(dataArray[i].ptr) << " its data type is : char" << std::endl;
                break;
            default:
                std::cout << "Unknown data type at index " << i << std::endl;
                break;
            }
        }
    }
};

int main()
{
    vPtrArray arr(5);

    int intValue = 10;
    double doubleValue = 3.14;
    char charValue = 'A';

    arr.SetVal(&intValue, 0, Datatype::INT);
    arr.SetVal(&doubleValue, 1, Datatype::DOUBLE);
    arr.SetVal(&charValue, 2, Datatype::CHAR);

    arr.printArray();

    return 0;
}
