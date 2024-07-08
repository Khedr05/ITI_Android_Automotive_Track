#include <iostream>



class car
{
private:

    std::string company;
    std::string model;
    int year;

public:

    car()
    {
        company = "";
        model = "";
        year = 0;
    }

    car(std::string carCompany, std::string carModel, int carYear)
    {
        company = carCompany;
        model = carModel;
        year = carYear;
    }


    void setCarCompany(std::string carCompany)
    {
        company = carCompany;
    }

    void setCarModel(std::string carModel)
    {
        model = carModel;
    }

    void setCarYear(int carYear)
    {
        year = carYear;
    }


    void getCarCompany(std::string* carCompany)
    {
        *carCompany = company;
    }

    void getCarModel(std::string* carModel)
    {
        *carModel = model;
    }

    void getCarYear(int* carYear)
    {
        *carYear = year;
    }

    void setcar(std::string carCompany, std::string carModel, int carYear)
    {
        company = carCompany;
        model = carModel;
        year = carYear;
    }

    void getcar(std::string* carCompany, std::string* carModel, int* carYear)
    {
        *carCompany = company;
        *carYear = year;
        *carYear = year;
    }

    void print(void)
    {
        std::cout << "Printing Car Info" << std::endl;
        std::cout << "Car Company : " << company << std::endl;
        std::cout << "Car Model   : " << model << std::endl;
        std::cout << "Car Year    : " << year << std::endl;
    }

};



int main(void)
{
    car c;
    car c2("bmw", "m4", 2024);
    std::string company, model;
    int year;

    c.print();
    c2.print();
    c.setcar("nissan", "gtr", 2020);
    c.print();
    c.setCarCompany("mercedes");
    c.setCarModel("c63");
    c.setCarYear(2025);
    c.print();
    c.getcar(&company, &model, &year);

    c2.getCarCompany(&company);
    c2.getCarModel(&model);
    c2.getCarYear(&year);

    std::cout << "Printing Car Info By Getter Functions" << std::endl;
    std::cout << "Car Company : " << company << std::endl;
    std::cout << "Car Model   : " << model << std::endl;
    std::cout << "Car Year    : " << year << std::endl;



}