#include <iostream>
#include <string>
#include <string_view>


std::string replacementStr(std::string_view haystack, std::string_view needle, std::string_view replacement)
{
    std::string newStr(haystack);
    int index = newStr.find(needle);
    while (index != std::string::npos)
    {
        newStr.replace(index, needle.length(), replacement);
        index = newStr.find(needle, index + needle.length());
    }

    return newStr;
}


int main(void)
{
    std::string haystack, needle, rep;
    getline(std::cin, haystack);
    getline(std::cin, needle);
    getline(std::cin, rep);

    std::cout << replacementStr(haystack, needle, rep);
}