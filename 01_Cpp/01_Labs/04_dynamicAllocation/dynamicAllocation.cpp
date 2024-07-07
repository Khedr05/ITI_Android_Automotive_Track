#include <iostream>

namespace nsDynamicAllocation
{
    int** create2dArray(int size)
    {
       int **dptr = new int *[size];

        for (int i = 0; i < size; i++) 
        {
            dptr[i] = new int[5];
        }
        return dptr;
    }

    void delete2dArray(int **dptr,int size)
    {
        for(int i=0;i<size;i++)
        {
            delete[] dptr[i];
        }

        delete[] dptr;
    }
    
}


int main(void)
{
    
    int size = 10;
    int **dptr = nsDynamicAllocation::create2dArray(size);

    for (int i = 0; i < size; ++i) 
    {
        for (int j = 0; j < 5; ++j) 
        {
            dptr[i][j] = i;
            std::cout << dptr[i][j] << " ";
        }
        std::cout << std::endl;
    }

    nsDynamicAllocation::delete2dArray(dptr,size);
}
