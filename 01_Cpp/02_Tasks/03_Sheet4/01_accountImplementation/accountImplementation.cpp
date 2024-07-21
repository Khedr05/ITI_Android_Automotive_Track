#include <iostream>
#include <ctime>

class Account
{
private:
    static int m_noOfAccounts;
    static int m_totalAmount;
    static int m_totalNbDeposits;
    static int m_totalNbWithdrawals;

    // Displays the current timestamp (Will be used in displayAccountsInfos())
    static void m_displayTimestamp(void)
    {
        // Get the current time
        std::time_t now = std::time(nullptr);

        // Convert to local time
        std::tm* local_time = std::localtime(&now);

        // Print the time in the format [YYYYMMDD_HHMMSS]
        std::cout << '[' << (local_time->tm_year + 1900)
            << (local_time->tm_mon + 1)
            << local_time->tm_mday << '_'
            << local_time->tm_hour
            << local_time->tm_min
            << local_time->tm_sec << "] ";
    }

    int m_accountIndex;
    int m_amount;
    int m_noOfDeposits;
    int m_noOfWithdrawals;

public:
    using acc = Account;

    Account() : m_accountIndex(m_noOfAccounts), m_amount(0), m_noOfDeposits(0), m_noOfWithdrawals(0)
    {
        m_noOfAccounts++;
        m_displayTimestamp();
        std::cout << "Account " << m_accountIndex << " created.\n";
    }

    Account(int initial_deposit) : m_accountIndex(m_noOfAccounts), m_amount(initial_deposit), m_noOfDeposits(1), m_noOfWithdrawals(0)
    {
        m_noOfAccounts++;
        m_totalNbDeposits++;
        m_totalAmount += initial_deposit;

        m_displayTimestamp();
        std::cout << "Account " << m_accountIndex << " created with initial deposit of " << initial_deposit << ".\n";
    }

    ~Account()
    {
        m_displayTimestamp();
        std::cout << "Account " << m_accountIndex << " closed.\n";
    }

    // Returns the number of accounts
    static int getNoOfAccounts(void)
    {
        return m_noOfAccounts;
    }

    // Returns the total amount of all accounts
    static int getTotalAmount(void)
    {
        return m_totalAmount;
    }

    // Returns the number of deposits
    static int getNbDeposits(void)
    {
        return m_totalNbDeposits;
    }

    // Returns the number of withdrawals
    static int getNoOfWithdrawals(void)
    {
        return m_totalNbWithdrawals;
    }

    // Displays the number of accounts, the total amount of deposits, the total amount of withdrawals, and the total amount of all accounts
    static void displayAccountsInfos(void)
    {
        m_displayTimestamp();
        std::cout << "Accounts: " << m_noOfAccounts
            << "; Total: " << m_totalAmount
            << "; Deposits: " << m_totalNbDeposits
            << "; Withdrawals: " << m_totalNbWithdrawals << '\n';
    }

    void makeDeposit(int deposit)
    {
        m_totalNbDeposits++;
        m_totalAmount += deposit;

        m_amount += deposit;
        m_noOfDeposits++;

        m_displayTimestamp();
        std::cout << "Account " << m_accountIndex << " deposit: " << deposit
            << "; Balance: " << m_amount << '\n';
    }

    bool makeWithdrawal(int withdrawal)
    {
        m_displayTimestamp();
        if (withdrawal <= m_amount)
        {
            m_totalNbWithdrawals++;
            m_totalAmount -= withdrawal;

            m_amount -= withdrawal;
            m_noOfWithdrawals++;

            std::cout << "Account " << m_accountIndex << " withdrawal: " << withdrawal
                << "; Balance: " << m_amount << '\n';

            return true;
        }
        else
        {
            std::cout << "Account " << m_accountIndex << " withdrawal: Refused\n";
            return false;
        }
    }

    int checkAmount(void) const
    {
        return m_amount;
    }

    void displayStatus(void) const
    {
        m_displayTimestamp();
        std::cout << "Account " << m_accountIndex << ": Balance: " << m_amount
            << "; Deposits: " << m_noOfDeposits
            << "; Withdrawals: " << m_noOfWithdrawals << '\n';
    }
};

// Initialize static member variables
int Account::m_noOfAccounts = 0;
int Account::m_totalAmount = 0;
int Account::m_totalNbDeposits = 0;
int Account::m_totalNbWithdrawals = 0;

int main(void)
{
    Account acc1(1000);
    acc1.displayStatus();

    Account acc2(500);
    acc2.displayStatus();

    acc1.makeDeposit(200);
    acc1.makeWithdrawal(300);
    acc1.displayStatus();

    acc2.makeWithdrawal(1000);
    acc2.displayStatus();

    Account::displayAccountsInfos();

    return 0;
}
