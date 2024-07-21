#include <iostream>
#include <initializer_list>
#include <string>


template <typename T>
class vector
{
private:

    T* array;
    int capacity;
    int size;

public:

    vector()
    {
        array = new T[1];
        capacity = 1;
        size = 0;
    }

    vector(int c)
    {
        array = new T[c];
        capacity = c;
        size = 0;
    }

    vector(int c, T val)
    {
        array = new T[c];
        capacity = c;
        size = c;
        for (int i = 0;i < c;i++)
        {
            array[i] = val;
        }
    }

    vector(int c, std::initializer_list<T> list)
    {
        array = new T[c];
        capacity = c;
        int itrator = 0;
        size = list.size();
        for (auto listVal : list)
        {
            array[itrator++] = listVal;
        }
    }

    vector(const vector& instance)
    {
        capacity = instance.capacity;
        size = instance.size;
        array = new T[capacity];
        for (int i = 0; i < size; i++)
        {
            array[i] = instance.array[i];
        }
    }

    ~vector()
    {
        delete[] array;
    }

    void resize(void)
    {
        T* newArr = new T[(capacity * 2)];

        for (int i = 0;i < size;i++)
        {
            newArr[i] = array[i];
        }

        delete[] array;
        array = newArr;
        capacity *= 2;
    }

    int getSize(void)
    {
        return size;
    }

    bool isFull(void)
    {
        return capacity == size;
    }

    void pushback(T value)
    {
        if (isFull() == true)
        {
            resize();
        }
        else {/*Do Nothing*/ }
        array[size] = value;
        size++;
    }

    void  popback(void)
    {
        if (size > 0)
        {
            size--;
        }
        else {/*Do Nothing*/ }
    }

    void removeAt(int index)
    {
        for (int i = index;i < size;i++)
        {
            array[index] = array[index + 1];
        }
        size--;
    }

    void insertAt(int index, T value)
    {
        if (isFull() == true)
        {
            resize();
        }
        else {/*Do Nothing*/ }
        for (int i = size;i > index;i--)
        {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    void insertMiddle(T value)
    {
        if (isFull() == true)
        {
            resize();
        }
        else {/*Do Nothing*/ }
        int middle = size / 2;
        insertAt(middle, value);
    }

    void removeMiddle(void)
    {
        int middle = size / 2;
        removeAt(middle);
    }

    void print(void)
    {
        for (int i = 0;i < size;i++)
        {
            std::cout << "Value In Index " << i << " Is : " << array[i] << std::endl;
        }
    }

};



int main()
{

    //Test on integer

    // Test default constructor
    vector<int> vec1;
    std::cout << "Initial vector size (vec1): " << vec1.getSize() << std::endl;

    // Test constructor with capacity
    vector<int> vec2(5);
    std::cout << "Initial vector size (vec2): " << vec2.getSize() << std::endl;

    // Test constructor with capacity and default value
    vector<int> vec3(5, 10);
    std::cout << "Vector vec3 after initialization:" << std::endl;
    vec3.print();

    // Test initializer list constructor
    vector<int> vec4(5, { 1, 2, 3, 4, 5 });
    std::cout << "Vector vec4 initialized with list:" << std::endl;
    vec4.print();

    // Test copy constructor
    vector<int> vec5 = vec4;
    std::cout << "Vector vec5 (copy of vec4):" << std::endl;
    vec5.print();

    // Test pushback
    vec1.pushback(100);
    vec1.pushback(200);
    std::cout << "Vector vec1 after pushback:" << std::endl;
    vec1.print();

    // Test popback
    vec1.popback();
    std::cout << "Vector vec1 after popback:" << std::endl;
    vec1.print();

    // Test insertAt
    vec3.insertAt(2, 50);
    std::cout << "Vector vec3 after insertAt(2, 50):" << std::endl;
    vec3.print();

    // Test removeAt
    vec3.removeAt(1);
    std::cout << "Vector vec3 after removeAt(1):" << std::endl;
    vec3.print();

    // Test insertMiddle
    vec3.insertMiddle(99);
    std::cout << "Vector vec3 after insertMiddle(99):" << std::endl;
    vec3.print();

    // Test removeMiddle
    vec3.removeMiddle();
    std::cout << "Vector vec3 after removeMiddle:" << std::endl;
    vec3.print();

    // Test on string

    // Test default constructor
    vector<std::string> emptyVector;
    std::cout << "Initial vector size (emptyVector): " << emptyVector.getSize() << std::endl;

    // Test constructor with capacity
    vector<std::string> reservedVector(3);
    std::cout << "Initial vector size (reservedVector): " << reservedVector.getSize() << std::endl;

    // Test constructor with capacity and default value
    vector<std::string> filledVector(3, "hello");
    std::cout << "Vector filledVector after initialization:" << std::endl;
    filledVector.print();

    // Test initializer list constructor
    vector<std::string> listInitializedVector(5, { "one", "two", "three", "four", "five" });
    std::cout << "Vector listInitializedVector initialized with list:" << std::endl;
    listInitializedVector.print();

    // Test copy constructor
    vector<std::string> copiedVector = listInitializedVector;
    std::cout << "Vector copiedVector (copy of listInitializedVector):" << std::endl;
    copiedVector.print();

    // Test pushback
    emptyVector.pushback("apple");
    emptyVector.pushback("banana");
    std::cout << "Vector emptyVector after pushback:" << std::endl;
    emptyVector.print();

    // Test popback
    emptyVector.popback();
    std::cout << "Vector emptyVector after popback:" << std::endl;
    emptyVector.print();

    // Test insertAt
    filledVector.insertAt(1, "world");
    std::cout << "Vector filledVector after insertAt(1, 'world'):" << std::endl;
    filledVector.print();

    // Test removeAt
    filledVector.removeAt(2);
    std::cout << "Vector filledVector after removeAt(2):" << std::endl;
    filledVector.print();

    // Test insertMiddle
    filledVector.insertMiddle("middle");
    std::cout << "Vector filledVector after insertMiddle('middle'):" << std::endl;
    filledVector.print();

    // Test removeMiddle
    filledVector.removeMiddle();
    std::cout << "Vector filledVector after removeMiddle:" << std::endl;
    filledVector.print();

    // Test isFull
    std::cout << "Is reservedVector full? " << (reservedVector.isFull() ? "Yes" : "No") << std::endl;

    // Fill reservedVector to capacity to test resizing
    reservedVector.pushback("first");
    reservedVector.pushback("second");
    reservedVector.pushback("third");
    std::cout << "Vector reservedVector after filling to capacity:" << std::endl;
    reservedVector.print();
    std::cout << "Is reservedVector full now? " << (reservedVector.isFull() ? "Yes" : "No") << std::endl;

    // Test resizing by adding more elements
    reservedVector.pushback("fourth");
    std::cout << "Vector reservedVector after resizing and adding 'fourth':" << std::endl;
    reservedVector.print();

    // Confirm resizing
    std::cout << "New capacity of reservedVector after resizing: " << reservedVector.getSize() << std::endl;



    return 0;
}