#include <iostream>
#include <cstdlib>
#include <ctime>
#include <vector>

class battleship
{
private:
    std::vector<std::vector<bool>> board;
    int guesses;
    int maxGuesses;
    int locationX;
    int locationY;
    int boardLimit;

public:
    battleship(int noOfGuesses)
    {
        maxGuesses = noOfGuesses;
        guesses = 0;
        boardLimit = 5;
        board = std::vector<std::vector<bool>>(boardLimit, std::vector<bool>(boardLimit, false));
        std::srand(std::time(0));
        locationX = std::rand() % boardLimit;
        locationY = std::rand() % boardLimit;

        board[locationX][locationY] = true;

        // std::cout << "Battleship is located at: " << locationX << ", " << locationY << std::endl;
    }

    bool guess(int x, int y)
    {
        if ((x < boardLimit) && (y < boardLimit))
        {
            if ((x == locationX) && (y == locationY))
            {
                std::cout << "You Won In " << (guesses + 1) << " guesses" << std::endl;
                return true;
            }
            else if (x == locationX)
            {
                std::cout << "You missed..... you have " << (maxGuesses - (guesses + 1)) << " guesses left" << std::endl;
                std::cout << "You are on the same row as the battleship" << std::endl;
                guesses++;
            }
            else if (y == locationY)
            {
                std::cout << "You missed..... you have " << (maxGuesses - (guesses + 1)) << " guesses left" << std::endl;
                std::cout << "You are on the same column as the battleship" << std::endl;
                guesses++;
            }
            else
            {
                std::cout << "You missed..... you have " << (maxGuesses - (guesses + 1)) << " guesses left" << std::endl;
                guesses++;
            }
        }
        else
        {
            std::cout << "Out of boundary" << std::endl;
        }
        return false;
    }

    bool gameOver(void) const
    {
        return maxGuesses == guesses;
    }

    int getGuesses(void) const
    {
        return guesses;
    }
};

int main(void)
{
    battleship game(5);
    int x = 0, y = 0;

    std::cout << "Welcome to battleship" << std::endl;
    std::cout << "You have 5 guesses to find the battleship hidden in a 5x5 grid" << std::endl;

    while (1)
    {
        if (!game.gameOver())
        {
            std::cout << "Enter your guess (row and column) : ";
            std::cin >> x >> y;
            if (game.guess(x, y))
                break;
        }
        else
        {
            std::cout << "Out of guesses" << std::endl;
            break;
        }
    }
}
