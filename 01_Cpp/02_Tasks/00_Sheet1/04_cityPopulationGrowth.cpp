#include <iostream>
#include <cmath>
using namespace std;

int main() 
{

    // Exponential growth formula:
    // P(t) = P0 * (1 + r)^t
    // Where:
    // P(t) is the population after t years,
    // P0 is the initial population,
    // r is the annual growth rate,
    // t is the number of years.

    int P0 = 162100; 
    double r = 0.065;  
    int targetPopulation = 1000000; 
    double years = log10(targetPopulation / P0) / log10(1 + r);

    cout << "Initial population: " << P0 << endl;
    cout << "Annual growth rate: " << r * 100 << "%" << endl;
    cout << "Population surpasses 1 million in approximately " << ceil(years) << " years." << endl;


    for (int year = 1; year <= ceil(years);year++)
    {
        double currentPopulation = P0 * pow(1 + r, year);
        cout << "Year " << year << ": Population = " << currentPopulation << endl;
    }

    return 0;
}


