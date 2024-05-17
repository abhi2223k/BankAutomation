//Abhishek Kale
package bank;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class SalaryAccount extends SavingAccount
{
	LocalDate lastTransactionDate ;
	int timeLimit = 60;
	/**
	 * @param acc_name
	 * @param acc_no
	 * @param balance
	 * @param intrestrate
	 */
	public SalaryAccount(String acc_name, double acc_no, double balance, double intrestrate,String  lastTransactionDate) 
	{
		super(acc_name, acc_no, balance, intrestrate);
		// TODO Auto-generated constructor stub
		this.lastTransactionDate = LocalDate.parse(lastTransactionDate);
	}
	
	public LocalDate getLastTransactionDate() 
	{
		return lastTransactionDate;
	}
	public void setLastTransactionDate(LocalDate  lastTransactionDate) 
	{
		this.lastTransactionDate = lastTransactionDate;
	}
	public int getTimeLimit() 
	{
		return timeLimit;
	}
	@Override
	public void deposit() 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		double amt;
		System.out.println("Enter amount to deposit");
		 amt = sc.nextDouble();
		this.setBalance(amt + this.getBalance());
		System.out.println("deposit is sucessfull");
		this.setLastTransactionDate(LocalDate.now());
		return;
		
		
	}
	@Override
	public void withdrawal() {
		    long monthsSinceLastTransaction = ChronoUnit.MONTHS.between(lastTransactionDate, LocalDate.now());
		    if (monthsSinceLastTransaction <= timeLimit) 
		    {
		    	Scanner sc = new Scanner (System.in);
				System.out.println("Enter amount to withdrawal");
				double amt = sc.nextDouble();
				
				if((this.getBalance() - amt)>=0)
				{
					this.setBalance( this.getBalance() - amt);
					System.out.println("Withdrawal Successful");
					this.setLastTransactionDate(LocalDate.now());
					return;
				}
		    } else {
		        // Withdrawal is not allowed
		        System.out.println("Withdrawal not allowed,Account is freeze.");
		    }
		}
		
	
	@Override
	public void checkBalance() {
		// TODO Auto-generated method stub
		System.out.println("Salary Account Balance is : "+ this.getBalance());
	}
	
	

	
	

}
