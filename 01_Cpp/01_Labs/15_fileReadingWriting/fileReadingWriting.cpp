#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <iomanip>



double sum(std::vector<double>& num)
{
    double sum = 0;
    for (int i = 0;i < num.size();i++)
    {
        sum += num[i];
    }
    return sum;
}


double avg(std::vector<double>& num)
{
    double avg = 0;
    for (int i = 0;i < num.size();i++)
    {
        avg += num[i];
    }
    return avg / num.size();
}

double min(std::vector<double>& num)
{
    double min = num[0];
    for (int i = 0;i < num.size();i++)
    {
        if (min > num[i])
        {
            min = num[i];
        }
    }
    return min;
}


double max(std::vector<double>& num)
{
    double max = num[0];
    for (int i = 0;i < num.size();i++)
    {
        if (max < num[i])
        {
            max = num[i];
        }
    }
    return max;
}


int main()
{
    std::ifstream inputFile("input.txt");
    if (!inputFile)
    {
        std::cerr << "Unable to open file";
        return 1;
    }

    std::vector<double> numbers;
    std::string line;

    while (std::getline(inputFile, line))
    {
        double number = std::stod(line);
        numbers.push_back(number);
    }

    inputFile.close();


    double sumRet = sum(numbers);
    double avgRet = avg(numbers);
    double minRet = min(numbers);
    double maxRet = max(numbers);

    const int columnWidth = 15;

    std::ofstream outputFile("output.txt");
    if (!outputFile)
    {
        std::cerr << "Unable to create output file";
        return 1;
    }

    outputFile << std::setw(4 * (columnWidth * 2)) << std::setfill('-') << "" << std::endl;

    outputFile << "|" << std::setw(columnWidth) << std::setfill(' ') << std::right << "Sum" << std::setw(columnWidth) << " | "
        << std::setw(columnWidth) << std::right << "Avg" << std::setw(columnWidth) << " | "
        << std::setw(columnWidth) << std::right << "Min" << std::setw(columnWidth) << " | "
        << std::setw(columnWidth) << std::right << "Max" << std::setw(columnWidth) << " | "
        << std::endl;

    outputFile << std::setw(4 * (columnWidth * 2)) << std::setfill('-') << "" << std::endl;

    outputFile << std::fixed << std::setprecision(2);
    outputFile << "|" << std::setw(columnWidth) << std::setfill(' ') << std::right << sumRet << std::setw(columnWidth) << " | "
        << std::setw(columnWidth) << std::right << avgRet << std::setw(columnWidth) << " | "
        << std::setw(columnWidth) << std::right << minRet << std::setw(columnWidth) << " | "
        << std::setw(columnWidth) << std::right << maxRet << std::setw(columnWidth) << " | "
        << std::endl;

    outputFile << std::setw(4 * (columnWidth * 2)) << std::setfill('-') << "" << std::endl;

    outputFile.close();


    /*
        std::cout << std::setw(4 * (columnWidth * 2)) << std::setfill('-') << "" << std::endl;

        std::cout << "|" << std::setw(columnWidth) << std::setfill(' ') << std::right << "Sum" << std::setw(columnWidth) << " | "
            << std::setw(columnWidth) << std::right << "Avg" << std::setw(columnWidth) << " | "
            << std::setw(columnWidth) << std::right << "Min" << std::setw(columnWidth) << " | "
            << std::setw(columnWidth) << std::right << "Max" << std::setw(columnWidth) << " | "
            << std::endl;

        std::cout << std::setw(4 * (columnWidth * 2)) << std::setfill('-') << "" << std::endl;


        std::cout << std::fixed << std::setprecision(2);
        std::cout << "|" << std::setw(columnWidth) << std::setfill(' ') << std::right << sumRet << std::setw(columnWidth) << " | "
            << std::setw(columnWidth) << std::right << avgRet << std::setw(columnWidth) << " | "
            << std::setw(columnWidth) << std::right << minRet << std::setw(columnWidth) << " | "
            << std::setw(columnWidth) << std::right << maxRet << std::setw(columnWidth) << " | "
            << std::endl;

        std::cout << std::setw(4 * (columnWidth * 2)) << std::setfill('-') << "" << std::endl;
    */

    return 0;
}
