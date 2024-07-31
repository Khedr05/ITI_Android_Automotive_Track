#include <iostream>
#include <thread>
#include <mutex>
#include <condition_variable>

int result;
std::mutex mtx;
std::condition_variable cv;
bool ready = false;

bool isReady()
{
    return ready;
}
int fibonacci(int n)
{
    if (n <= 1) return n;
    int a = 0, b = 1;
    for (int i = 2; i <= n;i++)
    {
        int temp = a + b;
        a = b;
        b = temp;
    }
    return b;
}
void fiboThread(int n)
{
    int local_result = fibonacci(n);
    std::lock_guard<std::mutex> lock(mtx);
    result = local_result;
    ready = true;
    cv.notify_one();
}

int main()
{
    int number = 17;

    std::thread t(fiboThread, number);

    std::unique_lock<std::mutex> lock(mtx);
    cv.wait(lock, isReady);

    std::cout << "Fibonacci(" << number << ") = " << result << std::endl;

    t.join();

    return 0;
}
