class Solution {
public:
    int addDigits(int num)
    {
        int rem = 0;

        while (num > 9)
        {
            rem = num % 10;
            num /= 10;
            num += rem;
        }
        return num;
    }
};