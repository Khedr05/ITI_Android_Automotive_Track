#include <iostream>
#include <thread>
#include <chrono>

void generateBeepThread(std::chrono::seconds interval)
{
    while (true)
    {
        std::cout << "beep" << std::endl;
        std::cout << '\a';
        std::this_thread::sleep_for(std::chrono::seconds(interval));
    }
}


void stopBeepThread(void)
{
    char input;
    std::cin.get(input);

    if (input == '\n') {
        exit(0);
    }
}

int main()
{

    std::cout << "Press Enter To Stop" << std::endl;
    std::chrono::seconds interval(3);
    std::thread beepThread(generateBeepThread, interval);
    std::thread stopThread(stopBeepThread);

    stopThread.join();
    beepThread.join();

    return 0;
}
