//Jayesh Kardile
package bank;

public abstract class Account {
    String accountName;
    double accountNumber;
    double balance;

    public Account(String accountName, double accountNumber, double balance) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void deposit();
    public abstract void withdrawal();
    public abstract void interestCal();
    public abstract void checkBalance();

	

	
}
