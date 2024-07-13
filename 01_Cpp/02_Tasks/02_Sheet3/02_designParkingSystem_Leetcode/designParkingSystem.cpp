class ParkingSystem
{
    int bigSlot;
    int mediumSlot;
    int smallSlot;
public:

    ParkingSystem(int big, int medium, int small)
    {
        bigSlot = big;
        mediumSlot = medium;
        smallSlot = small;
    }

    bool addCar(int carType)
    {
        bool ret;
        switch (carType)
        {
        case 1:
        {
            if (bigSlot > 0)
            {
                bigSlot--;
                ret = true;
            }
            else
            {
                ret = false;
            }
            break;
        }
        case 2:
        {
            if (mediumSlot > 0)
            {
                mediumSlot--;
                ret = true;
            }
            else
            {
                ret = false;
            }
            break;
        }
        case 3:
        {
            if (smallSlot > 0)
            {
                smallSlot--;
                ret = true;
            }
            else
            {
                ret = false;
            }
            break;
        }
        }
        return ret;
    }
};

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem* obj = new ParkingSystem(big, medium, small);
 * bool param_1 = obj->addCar(carType);
 */