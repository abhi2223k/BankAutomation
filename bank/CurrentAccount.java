//Abhishek Kale
package bank;

import java.util.Scanner;

public class CurrentAccount extends Account {
    private double overdraftLimit = 15000;
    private double overdraftAmount;

    public CurrentAccount(String accountName, double accountNumber, double balance, double overdraftAmount) {
        super(accountName, accountNumber, balance);
        this.overdraftAmount = overdraftAmount;
    }

    @Override
    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to deposit");
        double amount = sc.nextDouble();
        if (this.overdraftAmount == 0) {
            this.setBalance(this.getBalance() + amount);
            System.out.println("Deposit successful");
        } else {
            if (amount > overdraftAmount) {
                amount -= overdraftAmount;
                this.setBalance(this.getBalance() + amount);
                this.overdraftAmount = 0;
                System.out.println("Deposit successful, overdraft amount cleared");
            } else if (amount <= this.overdraftAmount) {
                this.overdraftAmount -= amount;
                this.overdraftLimit += amount;
                System.out.println("Deposit successful, overdraft amount reduced");
            } else {
                System.out.println("Invalid deposit amount");
            }
        }
    }

    @Override
    public void withdrawal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to withdraw");
        double amount = sc.nextDouble();
        if (this.getBalance() >= amount) {
            this.setBalance(this.getBalance() - amount);
            System.out.println("Withdrawal successful");
        } else if ((this.overdraftLimit + this.getBalance()) >= amount) {
            double remainingAmount = amount - this.getBalance();
            this.overdraftAmount += remainingAmount;
            this.setBalance(0);
            this.overdraftLimit -= remainingAmount;
            System.out.println("Withdrawal successful, overdraft amount utilized");
        } else {
            System.out.println("Withdrawal not allowed");
        }
    }

    @Override
    public void interestCal() {
        System.out.println("No interest for current account");
    }

    @Override
    public void checkBalance() {
        System.out.println("Balance: " + this.getBalance());
    }
}
