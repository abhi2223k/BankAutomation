//Supriya Chaugule
package bank;

import java.util.Scanner;

public class SavingAccount extends Account {
     double minBalance = 10000;
     double interestRate;

    public SavingAccount(String accountName, double accountNumber, double balance, double interestRate) {
        super(accountName, accountNumber, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to deposit");
        double amount = sc.nextDouble();
        this.setBalance(this.getBalance() + amount);
        System.out.println("Deposit successful");
        return;
    }

    @Override
    public void withdrawal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to withdraw");
        double amount = sc.nextDouble();
        if (this.getBalance() - amount >= minBalance) {
            this.setBalance(this.getBalance() - amount);
            System.out.println("Withdrawal successful");
            return;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public void interestCal() {
        double interest = this.getBalance() * this.interestRate / 100;
        System.out.println("Interest calculated: " + interest);
    }

    @Override
    public void checkBalance() {
        System.out.println("Balance: " + this.getBalance());
    }
}
