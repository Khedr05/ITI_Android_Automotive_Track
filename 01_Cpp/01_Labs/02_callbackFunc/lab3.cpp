#include <iostream>
using namespace std;



int addArr(int* arr, int size) 
{
    int res = 0;
    for (int i = 0; i < size;i++) 
    {
        res += arr[i];
    }
    return res;
}

typedef int* (*callbackFunc)(int**, int, int*, int (*)(int*, int));

int* mycallbackFunc(int** arr_2d, int arr_size, int* row_sizes, int (*func)(int*, int)) 
{
    int* res = (int*)malloc(arr_size * sizeof(int));

    for (int i = 0; i < arr_size; ++i) 
    {
        res[i] = func(arr_2d[i], row_sizes[i]);
    }

    return res;
}

int main() {

    #define No_OF_ARR 2

    int arr[No_OF_ARR][5] = { {0, 1, 2}, {3, 4, 5} };
    int row_sizes[2] = { 3, 3};

    int *arr_ptr[No_OF_ARR];
    for (int i = 0; i < No_OF_ARR; ++i) 
    {
        arr_ptr[i] = arr[i];
    }

    callbackFunc myFunc = mycallbackFunc;
    int* res = myFunc(arr_ptr, 2, row_sizes, addArr);

    for (int i = 0; i < 2; i++) 
    {
        cout << "Result " << i << ": " << res[i] << endl;
    }

    free(res);
    return 0;
}
