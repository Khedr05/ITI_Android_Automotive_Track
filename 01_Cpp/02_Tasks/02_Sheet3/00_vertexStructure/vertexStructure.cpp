#include <iostream>
#include <cstdlib>
#include <ctime>

struct Vertex
{
    int x;
    int y;
};

int generateRandomNumber(int min, int max)
{
    return min + (std::rand() % (max - min + 1));
}

int main(void)
{
    std::srand(static_cast<unsigned int>(std::time(0)));
    Vertex vertices[5];

    for (int i = 0; i < 5; i++)
    {
        vertices[i].x = generateRandomNumber(-100, 100);
        vertices[i].y = generateRandomNumber(-100, 100);
    }

    for (int i = 0; i < 5; i++)
    {
        std::cout << "v" << (i + 1) << ": (" << vertices[i].x << ", " << vertices[i].y << ")\n";
    }

    return 0;
}
