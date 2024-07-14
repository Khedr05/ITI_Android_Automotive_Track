#include <iostream>
#include <vector>

void transposeVector(const std::vector<std::vector<int>> matrix, std::vector<std::vector<int>>* transposedMatrix)
{
    int rows = matrix.size();
    int cols = matrix[0].size();

    transposedMatrix->clear();
    transposedMatrix->resize(cols);

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            (*transposedMatrix)[j].push_back(matrix[i][j]);
        }
    }
}

int main()
{
    std::vector<std::vector<int>> matrix1 = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
    std::vector<std::vector<int>> matrix2 = { {1, 2}, {3, 4}, {5, 6}, {7, 8} };
    std::vector<std::vector<int>> matrix3 = { {1, 2, 3, 4}, {5, 6, 7, 8} };
    std::vector<std::vector<int>> matrix4 = { {1, 2, 3}, {4, 5, 6} };
    std::vector<std::vector<int>> matrix5 = { {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25} };

    std::vector<std::vector<int>> transposedMatrix1;
    std::vector<std::vector<int>> transposedMatrix2;
    std::vector<std::vector<int>> transposedMatrix3;
    std::vector<std::vector<int>> transposedMatrix4;
    std::vector<std::vector<int>> transposedMatrix5;

    transposeVector(matrix1, &transposedMatrix1);
    transposeVector(matrix2, &transposedMatrix2);
    transposeVector(matrix3, &transposedMatrix3);
    transposeVector(matrix4, &transposedMatrix4);
    transposeVector(matrix5, &transposedMatrix5);

    std::cout << "Original Matrix 1:" << std::endl;
    for (auto row : matrix1)
    {
        for (int val : row)
        {
            std::cout << val << " ";
        }
        std::cout << std::endl;
    }

    std::cout << "Transposed Matrix 1:" << std::endl;
    for (auto row : transposedMatrix1)
    {
        for (int val : row)
        {
            std::cout << val << " ";
        }
        std::cout << std::endl;
    }

    std::cout << "Original Matrix 2:" << std::endl;
    for (auto row : matrix2)
    {
        for (int val : row)
        {
            std::cout << val << " ";
        }
        std::cout << std::endl;
    }

    std::cout << "Transposed Matrix 2:" << std::endl;
    for (auto row : transposedMatrix2)
    {
        for (int val : row)
        {
            std::cout << val << " ";
        }
        std::cout << std::endl;
    }

    std::cout << "Original Matrix 3:" << std::endl;
    for (auto row : matrix3)
    {
        for (int val : row)
        {
            std::cout << val << " ";
        }
        std::cout << std::endl;
    }

    std::cout << "Transposed Matrix 3:" << std::endl;
    for (auto row : transposedMatrix3)
    {
        for (int val : row)
        {
            std::cout << val << " ";
        }
        std::cout << std::endl;
    }

    std::cout << "Original Matrix 4:" << std::endl;
    for (auto row : matrix4)
    {
        for (int val : row)
        {
            std::cout << val << " ";
        }
        std::cout << std::endl;
    }

    std::cout << "Transposed Matrix 4:" << std::endl;
    for (auto row : transposedMatrix4)
    {
        for (int val : row)
        {
            std::cout << val << " ";
        }
        std::cout << std::endl;
    }

    std::cout << "Original Matrix 5:" << std::endl;
    for (auto row : matrix5)
    {
        for (int val : row)
        {
            std::cout << val << " ";
        }
        std::cout << std::endl;
    }

    std::cout << "Transposed Matrix 5:" << std::endl;
    for (auto row : transposedMatrix5)
    {
        for (int val : row)
        {
            std::cout << val << " ";
        }
        std::cout << std::endl;
    }
    return 0;
}
