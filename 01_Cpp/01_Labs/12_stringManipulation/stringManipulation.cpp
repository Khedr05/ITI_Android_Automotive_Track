#include <iostream>


int main(void)
{
    std::string text = "The cycle of life is a cycle of cycles";
    int index = text.find("cycle");
    while (index != std::string::npos)
    {
        text.replace(index, 5, "circle");
        index = text.find("cycle");
    }

    index = text.find("circle");
    text.replace((index - 1), 0, " great");

    index = text.find("circle", text.find("circle") + 6);
    text.replace((index - 1), 0, " never-ending");

    std::cout << text;
}