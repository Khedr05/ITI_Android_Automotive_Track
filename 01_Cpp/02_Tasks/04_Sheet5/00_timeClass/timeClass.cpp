#include <iostream>

class Time
{
private:
    int hours;
    int minutes;
    int seconds;

public:
    // Default constructor initializes time to 0
    Time() : hours(0), minutes(0), seconds(0) {}

    // Constructor with parameters
    Time(int h, int m, int s) : hours(h), minutes(m), seconds(s) {}

    // Display function to show time in 11:59:59 format
    void displayTime() const
    {
        std::cout << (hours < 10 ? "0" : "") << hours << ":"
            << (minutes < 10 ? "0" : "") << minutes << ":"
            << (seconds < 10 ? "0" : "") << seconds << std::endl;
    }

    // Add two Time objects
    void addTime(const Time& t1, const Time& t2)
    {
        seconds = t1.seconds + t2.seconds;
        minutes = t1.minutes + t2.minutes + seconds / 60;
        hours = t1.hours + t2.hours + minutes / 60;

        // for overflow
        seconds %= 60;
        minutes %= 60;
        hours %= 24;  // Assuming a 24-hour time format
    }
};

int main()
{
    Time t1(15, 15, 30);
    Time t2(10, 30, 45);
    Time t3;

    t3.addTime(t1, t2);

    std::cout << "Time 1: ";
    t1.displayTime();

    std::cout << "Time 2: ";
    t2.displayTime();

    std::cout << "Added Time: ";
    t3.displayTime();

    return 0;
}
