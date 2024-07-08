#include <iostream>
#include <cstdint>

enum class errorCode : uint8_t
{
    BAD_REQUEST,
    NOT_FOUND,
    SERVER_ERROR,
    GATEWAY_TIMEOUT
};

void printError(errorCode error)
{
    if (error == errorCode::BAD_REQUEST)
    {
        std::cout << "400 Bad Request" << std::endl;
    }
    else if (error == errorCode::NOT_FOUND)
    {
        std::cout << "404 Not Found" << std::endl;
    }
    else if (error == errorCode::SERVER_ERROR)
    {
        std::cout << "500 Server Error" << std::endl;
    }
    else if (error == errorCode::GATEWAY_TIMEOUT)
    {
        std::cout << "504 Gateway Timeout" << std::endl;
    }
    else {/*Do Nothing*/ }
}


int main(void)
{
    printError(errorCode::BAD_REQUEST);
    printError(errorCode::GATEWAY_TIMEOUT);
    printError(errorCode::NOT_FOUND);
    printError(errorCode::SERVER_ERROR);
}