#include <iostream>
#include <string>
using namespace std;


struct name 
{
    string firstName;
    string middleName;
    string lastName;
};

struct date
 {
    int day;
    int month;
    int year;
};

struct address 
{
    string street;
    string city;
    string country;
};

struct contacts 
{
    string telephoneNumber;
    string mobileNumber;
    string emailAddress;
};

struct salary
 {
    double basic;
    double additional;
    double reductions;
    double taxes;
};

struct Employee 
{
    name employeeName;
    date employeeDateOfBirth;
    address employeeAddress;
    contacts employeeContacts;
    string employeeJobTitle;
    salary employeeSalary;
};

int main() 
{
    Employee emp;

    emp.employeeName.firstName = "Sherif";
    emp.employeeName.middleName = "Ashraf";
    emp.employeeName.lastName = "Khedr";

    emp.employeeDateOfBirth.day = 5;
    emp.employeeDateOfBirth.month = 5;
    emp.employeeDateOfBirth.year = 2005;

    emp.employeeAddress.street = "123 Main Street";
    emp.employeeAddress.city = "Anytown";
    emp.employeeAddress.country = "EGY";

    emp.employeeContacts.telephoneNumber = "555-123-4567";
    emp.employeeContacts.mobileNumber = "555-987-6543";
    emp.employeeContacts.emailAddress = "sherif.doe@example.com";

    emp.employeeJobTitle = "Software Engineer";

    emp.employeeSalary.basic = 5000.00;
    emp.employeeSalary.additional = 1000.00;
    emp.employeeSalary.reductions = 500.00;
    emp.employeeSalary.taxes = 1000.00;

    // Display the employee details
    cout << "Employee Name: " << emp.employeeName.firstName << " "
         << emp.employeeName.middleName << " " << emp.employeeName.lastName << endl;
    cout << "Date of Birth: " << emp.employeeDateOfBirth.day << "/"
         << emp.employeeDateOfBirth.month << "/" << emp.employeeDateOfBirth.year << endl;
    cout << "Address: " << emp.employeeAddress.street << ", " << emp.employeeAddress.city
         << ", " << emp.employeeAddress.country << endl;
    cout << "Telephone: " << emp.employeeContacts.telephoneNumber << endl;
    cout << "Mobile: " << emp.employeeContacts.mobileNumber << endl;
    cout << "Email: " << emp.employeeContacts.emailAddress << endl;
    cout << "Job Title: " << emp.employeeJobTitle << endl;
    cout << "Salary Details:" << endl;
    cout << "Basic: $" << emp.employeeSalary.basic << endl;
    cout << "Additional: $" << emp.employeeSalary.additional << endl;
    cout << "Deductions: $" << emp.employeeSalary.reductions << endl;
    cout << "Taxes: $" << emp.employeeSalary.taxes << endl;

    return 0;
}
