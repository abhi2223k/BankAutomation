//Supriya Chaugule
package bank;

import java.time.LocalDate;
import java.util.Scanner;

public class LoanAccount extends Account {
    private double loanGiven;
    private static double interestRate = 2.5;

    public LoanAccount(String accountName, double accountNumber, double balance, double loan) {
        super(accountName, accountNumber, balance);
        this.loanGiven = loan;
        loan+= (this.loanGiven / 100) * interestRate;
        this.setBalance(balance - loan);
    }

  
	@Override
    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to repay loan");
        double amount = sc.nextDouble();
        if (this.getBalance() - amount < 0) 
        {
        	this.balance+=amount;
    		this.loanGiven-=amount;
    		System.out.println("Deposit Sucessfully !!!");
    		System.out.println("\nRemaing Loan is = "+loanGiven);
            return;
        }
        else {
        	System.out.println("Deposit error balance greater than 0");
        	if(this.loanGiven==0) {
				System.out.println("\nYour Loan Is Cleared !!!");
			}
        
        }
        
    }

    @Override
    public void withdrawal() {
    	// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter amount to take as a loan");
		double amt = sc.nextDouble();
		if(this.balance >= 0)
		{
			this.setBalance( this.getBalance() - amt);
			System.out.println("Loan is given ");
			System.out.println("Loan to be paid is" + this.getBalance());
			
			return;
    }
    }

    @Override
    public void interestCal() {
        double interest = (this.loanGiven / 100) * interestRate;
        System.out.println("Interest to be paid: " + interest);
    }

    @Override
    public void checkBalance() {
        System.out.println("Balance: " + this.getBalance());
    }
}
