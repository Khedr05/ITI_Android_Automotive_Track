#include <stdio.h>
#include "../include/add.h"
#include "../include/subtract.h"
#include "../include/multiply.h"
#include "../include/divide.h"

int main() {
    double num1, num2;
    char op;

    printf("Enter your equation (e.g., 3 + 4) : ");
    if (scanf("%lf %c %lf", &num1, &op, &num2) != 3) 
    {
        printf("Invalid equation\n");
        return 1;
    }

    switch (op) {
        case '+':
            printf("Result: %lf\n", add(num1, num2));
            break;
        case '-':
            printf("Result: %lf\n", subtract(num1, num2));
            break;
        case '*':
            printf("Result: %lf\n", multiply(num1, num2));
            break;
        case '/':
            if (num2 == 0)
            {
                printf("Error: Division by zero\n");
            } else 
            {
                printf("Result: %lf\n", divide(num1, num2));
            }
            break;
        default:
            printf("Invalid operator\n");
    }

    return 0;
}
