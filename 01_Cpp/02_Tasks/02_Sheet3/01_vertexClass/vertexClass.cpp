#include <iostream>
#include <cstdlib>
#include <string>
#include <ctime>

class Vertex
{
private:
    int x;
    int y;

    int generateRandomNumber(int min, int max)
    {
        return min + (std::rand() % (max - min + 1));
    }

public:
    void setX(void)
    {
        x = generateRandomNumber(-100, 100);
    }

    void setY(void)
    {
        y = generateRandomNumber(-100, 100);
    }

    void setRandomValues(void)
    {
        setX();
        setY();
    }

    int getX(void)
    {
        return x;
    }

    int getY(void)
    {
        return y;
    }

    std::string getVertex(void)
    {
        std::string vString = "(";
        vString += std::to_string(x);
        vString += ", ";
        vString += std::to_string(y);
        vString += ")";
        return vString;
    }
};

int main()
{
    std::srand(static_cast<unsigned int>(std::time(0)));
    Vertex vertices[5];

    for (int i = 0; i < 5;i++)
    {
        vertices[i].setRandomValues();
    }


    for (int i = 0; i < 5;i++)
    {
        std::cout << "v" << (i + 1) << " : " << vertices[i].getVertex() << std::endl;
    }

    return 0;
}
