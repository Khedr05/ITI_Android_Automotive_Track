#include <iostream>
#include <cmath>

class Calculator
{
private:
    double num1;
    double num2;
    char op;

    void setNum1(double copyNum1)
    {
        num1 = copyNum1;
    }

    void setNum2(double copyNum2)
    {
        num2 = copyNum2;
    }

    void setOp(char copyOp)
    {
        op = copyOp;
    }

    double getNum1()
    {
        return num1;
    }

    double getNum2()
    {
        return num2;
    }

    char getOp()
    {
        return op;
    }

    double add()
    {
        return num1 + num2;
    }

    double subtract()
    {
        return num1 - num2;
    }

    double multiply()
    {
        return num1 * num2;
    }

    double divide()
    {
        if (num2 == 0)
        {
            std::cout << "Error Division by zero" << std::endl;
            return NAN;
        }
        return num1 / num2;
    }

    double power()
    {
        return pow(num1, num2);
    }

    double squareRoot()
    {
        if (num1 < 0)
        {
            std::cout << "Error square root of a negative number" << std::endl;
            return NAN;
        }
        return sqrt(num1);
    }

public:
    double getRes()
    {
        switch (op)
        {
        case '+':
            return add();
        case '-':
            return subtract();
        case '*':
            return multiply();
        case '/':
            return divide();
        case '^':
            return power();
        case 's':
            return squareRoot();
        default:
            std::cout << "Error Invalid Operator" << std::endl;
            return NAN;
        }
    }

    double userInterface()
    {
        double copyNum1, copyNum2;
        char copyOp;

        std::cout << "Enter First Number: ";
        std::cin >> copyNum1;
        setNum1(copyNum1);

        std::cout << "Choose Operator (+, -, *, /, ^, sqrt (s)): ";
        std::cin >> copyOp;
        setOp(copyOp);

        if (copyOp != 's')
        {
            std::cout << "Enter Second Number: ";
            std::cin >> copyNum2;
            setNum2(copyNum2);
        }

        return getRes();
    }
};

int main()
{
    Calculator c;
    while (1)
    {
        double res = c.userInterface();
        std::cout << "Result: " << res << std::endl;

    }

    return 0;
}
