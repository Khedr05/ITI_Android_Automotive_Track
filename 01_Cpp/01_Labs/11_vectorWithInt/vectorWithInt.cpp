/*
Implement a class for a dynamic array (Vector)
    * Containing the following functions
        * resize() - resize the array to double the size
        * pushback(value) - add the value to the end of the array
        * popback() - remove the last element from the array
        * removeAt(index) - remove the element at the given index
        * insertAt(index, value) - insert the value at the given index and shift the elements to the right
        * insertMiddle(value) - insert the value in the middle of the array
        * removeMiddle() - remove the middle element from the array
        * size() - return the size of the array
        * print() - print the array

    * The following overload constructors:
        * DynamicArray() - default constructor with capacity of 1
        * DynamicArray(size) - constructor with given capacity
        * DynamicArray(size, value) - constructor with given capacity and initial value for all elements --> DynamicArray arr(5, 10);
        * DynamicArray(size, values) - constructor with given capacity and initial values --> DynamicArray arr(5, new int[5]{1, 2, 3, 4, 5});
        * DynamicArray(arr) - copy constructor

    * Appropriate destructor

    - Private members:
        * array - pointer to the array
        * capacity - capacity of the array
        * currentSize - current size of the array
*/

#include <iostream>

class vector
{
private:

    int* array;
    int capacity;
    int size;

public:

    vector()
    {
        array = new int[1];
        capacity = 1;
        size = 0;
    }

    vector(int c)
    {
        array = new int[c];
        capacity = c;
        size = 0;
    }

    vector(int c, int val)
    {
        array = new int[c];
        capacity = c;
        size = c;
        for (int i = 0;i < c;i++)
        {
            array[i] = val;
        }
    }

    vector(int c, int* values)
    {
        array = new int[c];
        capacity = c;
        size = c;
        for (int i = 0; i < c; i++)
        {
            array[i] = values[i];
        }
    }

    vector(const vector& instance)
    {
        capacity = instance.capacity;
        size = instance.size;
        array = new int[capacity];
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
        int* newArr = new int[(capacity * 2)];

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

    void pushback(int value)
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
        array[size - 1] = 0;
        size--;
    }

    void removeAt(int index)
    {
        for (int i = index;i < size;i++)
        {
            array[index] = array[index + 1];
        }
        size--;
    }

    void insertAt(int index, int value)
    {
        for (int i = size;i > index;i--)
        {
            array[size] = array[size - 1];
        }
        array[index] = value;
        size++;
    }

    void insertMiddle(int value)
    {
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


int main() {
    // Testing default constructor
    vector v1;
    v1.pushback(1);
    v1.pushback(2);
    v1.pushback(3);
    std::cout << "Default constructor test (pushback 1, 2, 3):" << std::endl;
    v1.print();

    // Testing constructor with given capacity
    vector v2(5);
    v2.pushback(10);
    v2.pushback(20);
    v2.pushback(30);
    std::cout << "Constructor with capacity test (pushback 10, 20, 30):" << std::endl;
    v2.print();

    // Testing constructor with given capacity and initial value
    vector v3(5, 10);
    std::cout << "Constructor with capacity and initial value test (capacity 5, initial value 10):" << std::endl;
    v3.print();

    // Testing constructor with given capacity and initial values
    int values[] = { 1, 2, 3, 4, 5 };
    vector v4(5, values);
    std::cout << "Constructor with capacity and initial values test (1, 2, 3, 4, 5):" << std::endl;
    v4.print();

    // Testing copy constructor
    vector v5(v4);
    std::cout << "Copy constructor test (copy of previous vector):" << std::endl;
    v5.print();

    // Testing popback
    v4.popback();
    std::cout << "After popback (remove last element):" << std::endl;
    v4.print();

    // Testing removeAt
    v4.removeAt(2);
    std::cout << "After removeAt (remove element at index 2):" << std::endl;
    v4.print();

    // Testing insertAt
    v4.insertAt(2, 99);
    std::cout << "After insertAt (insert 99 at index 2):" << std::endl;
    v4.print();

    // Testing insertMiddle
    v4.insertMiddle(55);
    std::cout << "After insertMiddle (insert 55 in the middle):" << std::endl;
    v4.print();

    // Testing removeMiddle
    v4.removeMiddle();
    std::cout << "After removeMiddle (remove middle element):" << std::endl;
    v4.print();

    // Testing getSize
    std::cout << "Current size of vector: " << v4.getSize() << std::endl;

    // Testing resizing
    for (int i = 6; i <= 15; ++i) {
        v4.pushback(i);
    }
    std::cout << "After pushing back more elements to trigger resizing:" << std::endl;
    v4.print();

    return 0;
}