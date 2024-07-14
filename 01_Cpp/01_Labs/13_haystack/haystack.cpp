#include <iostream>
#include <string>


std::string replacementStr(std::string haystack, std::string needle, std::string replacement)
{
    int index = haystack.find(needle);
    while (index != std::string::npos)
    {
        haystack.replace(index, needle.length(), replacement);
        index = haystack.find(needle, index + 7);
    }

    return haystack;
}


int main(void)
{
    std::string haystack, needle, rep;
    getline(std::cin, haystack);
    getline(std::cin, needle);
    getline(std::cin, rep);

    std::cout << replacementStr(haystack, needle, rep);
    //std::cout << ret << std::endl;
}