#include <iostream>
#include <thread>
#include <atomic>

class spinLock
{
private:
    std::atomic_flag aFlag = ATOMIC_FLAG_INIT;

public:
    bool lock()
    {
        while (aFlag.test_and_set(std::memory_order_acquire))
        {
            std::this_thread::yield();
        }
        return true;
    }

    void unlock()
    {
        aFlag.clear(std::memory_order_release);
    }
};

void multiplyThread(spinLock& lock, int& sharedVar)
{
    for (int i = 0; i < 20; ++i)
    {
        sharedVar *= 2;
        std::cout << "Multiplied by 2: " << sharedVar << std::endl;
        lock.unlock();
    }
}

void divideThread(spinLock& lock, int& sharedVar)
{
    for (int i = 0; i < 20; ++i)
    {
        sharedVar /= 2;
        std::cout << "Divided by 2: " << sharedVar << std::endl;
        lock.unlock();
    }
}

int main()
{
    spinLock lock;
    int sharedVar = 1;

    std::thread t1(multiplyThread, std::ref(lock), std::ref(sharedVar));
    std::thread t2(divideThread, std::ref(lock), std::ref(sharedVar));

    t1.join();
    t2.join();

    return 0;
}
