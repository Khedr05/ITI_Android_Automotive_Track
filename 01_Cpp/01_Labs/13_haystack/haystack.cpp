#include <iostream>


std::string replacementStr(std::string haystack, std::string needle, std::string replacement)
{
    int index = haystack.find(needle);
    while (index != std::string::npos)
    {
        haystack.replace(index, 5, replacement);
        index = haystack.find(needle, index + 7);
    }

    return haystack;
}


int main(void)
{
    std::string ret = "";
    ret = replacementStr("The cycle of life is a cycle of cycles", "cycle", "circle");
    std::cout << ret << std::endl;
}