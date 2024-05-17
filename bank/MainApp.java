//Abhishe Kale ,Jayesh Kardile,Supriya Chaugule

package bank;

import java.time.LocalDate;
import java.util.Scanner;

public class MainApp {

	static void display() {
		System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
		System.out.println("║                            Bank Management System                          ║");
		System.out.println("║                          ╭────────────────────────────────╮                ║");
		System.out.println("║                          │           🌟 Team Awesome 🌟    │                ║");
		System.out.println("║                          ├────────────────────────────────┤                ║");
		System.out.println("║                          │       💼 Supriya Chaugule       │                ║");
		System.out.println("║                          │       💼 Abhishek Kale          │                ║");
		System.out.println("║                          │       💼 Jayesh Kardile         │                ║");
		System.out.println("║                          ╰────────────────────────────────╯                ║");
		System.out.println("║                                                                            ║");
		System.out.println("║                      Designed with Passion and Innovation                  ║");
		System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
	}

	public static void main(String[] args) {

		int ctr = -1, range = -1;
		Report[] report = new Report[50];
		Account[] accountArray = new Account[50];
		double number = 100;
		int choice, ch;
		display();

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("╔═════════════════════════════════════════════════╗");
			System.out.println("║              🏦 Welcome to the BANK 🏦          ║");
			System.out.println("╠═════════════════════════════════════════════════╣");
			System.out.println("║ 1 | 🌱 Create New Account                       ║");
			System.out.println("║ 2 | 💰 Deposit                                  ║");
			System.out.println("║ 3 | 💸 Withdraw                                 ║");
			System.out.println("║ 4 | 📈 Calculate Interest                       ║");
			System.out.println("║ 5 | 📊 End Day of Report                        ║");
			System.out.println("║ 6 | 🚪 Close Account                            ║");
			System.out.println("║ 7 | 🔍 Check Balance                            ║");
			System.out.println("║ 8 | 🚀 Exit program                             ║");
			System.out.println("╚════════════════════════════════════════════════╝");
			System.out.println("\n\n Enter your choice: ");

			choice = sc.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("|------------------------------------------|");
				System.out.println("|\t CHOOSE ACCOUNT TYPE               |");
				System.out.println("|------------------------------------------|");
				System.out.println("| 1 | Saving Account                       |");
				System.out.println("| 2 | Current Account                      |");
				System.out.println("| 3 | Salary  Account                      |");
				System.out.println("| 4 | Loan Account                         |");
				System.out.println("|------------------------------------------|");

				System.out.println("\n\n Enter the choice ");
				ch = sc.nextInt();

				switch (ch) {
				case 1: {
					System.out.println("================********************================");
					System.out.println("\n !!! Saving Account !!!");
					number++;
					System.out.println(" Enter account holder name ");
					String accHolderName = sc.next();
					System.out.println(" Enter account balance ");
					double balance = sc.nextDouble();
					if (balance < 10000) {
						System.out.println("Saving account requires a minimum balance of 10000!");
						System.out.println("Please enter an amount greater than the minimum balance!");
					} else {
						LocalDate transactionDate = LocalDate.now();
						double interestRate = 4.5;
						accountArray[++ctr] = new SavingAccount(accHolderName, number, balance, interestRate);
						report[++range] = new Report(number, "CreateAccount", balance);
						System.out.println("Welcome to our bank, your account has been successfully created!");
						System.out.println("\n YOUR SAVING ACCOUNT NO IS " + number);
					}
					System.out.println("================********************================");
				}
					break;

				case 2: {
					System.out.println("================********************================");
					System.out.println("\n !!! Current Account !!!");
					number++;
					System.out.println(" Enter account holder name ");
					String accHolderName = sc.next();
					System.out.println(" Enter account balance ");
					double balance = sc.nextDouble();
					accountArray[++ctr] = new CurrentAccount(accHolderName, number, balance, balance);
					report[++range] = new Report(number, "CreateAccount", balance);
					System.out.println("Welcome to our bank, your account has been successfully created!");
					System.out.println("\n YOUR CURRENT ACCOUNT NO IS " + number);
					System.out.println("================********************================");
				}
					break;

				case 3: {
					System.out.println("================********************================");
					System.out.println("\n !!! Salary Account !!!");
					number++;
					System.out.println(" Enter account holder name ");
					String accHolderName = sc.next();
					System.out.println(" Enter account balance ");
					double balance = sc.nextDouble();
					LocalDate transactionDate = LocalDate.now();
					// LocalDate lastDate = LocalDate.of(2023, 6, 6);
					sc.nextLine();
					System.out.println("Enter date in yyyy-MM-dd format");
					String lastDateStr = sc.nextLine(); // Read the entire line

					double interestRate = 6.5;
					accountArray[++ctr] = new SalaryAccount(accHolderName, number, balance, interestRate, lastDateStr);
					report[++range] = new Report(number, "CreateAccount", balance);
					System.out.println("Welcome to our bank, your account has been successfully created!");
					System.out.println("\n YOUR SALARY ACCOUNT NO IS " + number);
					System.out.println("================********************================");
				}
					break;

				case 4: {
					System.out.println("================********************================");
					System.out.println("\n !!! Loan Account !!!");
					number++;
					System.out.println(" Enter account holder name ");
					String accHolderName = sc.next();
					System.out.println(" Enter account balance ");
					double balance = sc.nextDouble();
					LocalDate transactionDate = LocalDate.now();
					System.out.println(" Enter loan amount ");
					double loan = sc.nextDouble();
					double interestRate = 6.5;

					accountArray[++ctr] = new LoanAccount(accHolderName, number, balance, loan);
					report[++range] = new Report(number, "CreateAccount", balance);
					System.out.println("Welcome to our bank, your account has been successfully created!");
					System.out.println("\n YOUR LOAN ACCOUNT NO IS " + number);
					System.out.println("================********************================");
				}
					break;

				default:
					System.out.println("\t Invalid choice !!!");
					break;
				}
			}
				break;

			case 2: {
				// Deposit operation
				System.out.println("================********************================");
				System.out.println("Enter account number to deposit: ");
				int accNo = sc.nextInt();
				int index = findAccountIndex(accNo, accountArray, ctr);

				if (index != -1) {
					System.out.println("Enter amount to deposit: ");
					double amount = sc.nextDouble();
					accountArray[index].deposit();
					report[++range] = new Report(accNo, "Deposit", amount);
				} else {
					System.out.println("Account not found!");
				}
				System.out.println("================********************================");
			}
				break;

			case 3: {
				// Withdraw operation
				System.out.println("================********************================");
				System.out.println("Enter account number to withdraw: ");
				int accNo = sc.nextInt();
				int index = findAccountIndex(accNo, accountArray, ctr);

				if (index != -1) {
					System.out.println("Enter amount to withdraw: ");
					double amount = sc.nextDouble();
					accountArray[index].withdrawal();
					report[++range] = new Report(accNo, "Withdraw", amount);
				} else {
					System.out.println("Account not found!");
				}
				System.out.println("================********************================");
			}
				break;

			case 4: {
				// Calculate interest
				System.out.println("================********************================");
				System.out.println("Enter account number to calculate interest: ");
				int accNo = sc.nextInt();
				int index = findAccountIndex(accNo, accountArray, ctr);

				if (index != -1) {
					accountArray[index].interestCal();
				} else {
					System.out.println("Account not found!");
				}
				System.out.println("================********************================");
			}
				break;

			case 5: {
				// End of day report
				System.out.println("================********************================");
				System.out.println("THIS IS ONLY FOR BANK RELEVANT PERSONNEL WHO WORK IN BANK");
				System.out.println("IF YOU WORK IN BANK THEN ENTER USERNAME AND PASSWORD");

				Scanner sc1 = new Scanner(System.in);

				System.out.println("\nEnter the username: ");
				String username = sc1.next();
				System.out.println("Enter the password: ");
				int pass = sc1.nextInt();

				if (username.equals("AJS") && pass == 7890) {
					System.out.println("---------------------------------------------------");
					System.out.println("Acc No\t|\tProcess\t\t|\tBalance");
					System.out.println("---------------------------------------------------");

					for (int itr = 0; itr <= range; itr++) {
						report[itr].endDayOfReport();
						System.out.println("---------------------------------------------------");
					}
				} else {
					System.out.println("Wrong Username and Password!");
				}
				System.out.println("\n================********************================");
			}
				break;

			case 6: {
				// Close account
				System.out.println("================********************================");
				System.out.println("Enter account number to close account: ");
				int accNo = sc.nextInt();
				int index = findAccountIndex(accNo, accountArray, ctr);

				if (index != -1) {
					for (int j = index; j < ctr; j++) {
						accountArray[j] = accountArray[j + 1];
					}
					ctr--;
					System.out.println("Account closed successfully!");
				} else {
					System.out.println("Account not found!");
				}
				System.out.println("================********************================");
			}
				break;

			case 7: {
				// Check balance
				System.out.println("================********************================");
				System.out.println("Enter account number to check balance: ");
				int accNo = sc.nextInt();
				int index = findAccountIndex(accNo, accountArray, ctr);

				if (index != -1) {
					System.out.println("Account Number: " + accountArray[index].getAccountNumber());
					System.out.println("Account Holder Name: " + accountArray[index].getAccountName());
					System.out.println("Account Balance: " + accountArray[index].getBalance());
				} else {
					System.out.println("Account not found!");
				}
				System.out.println("================********************================");
			}
				break;

			case 8:
				System.out.println("\nProgram Exit!");
				return;

			default:
				System.out.println("\n Invalid choice, try again !");
				break;
			}
		} while (choice >= 1 && choice <= 8);
	}

	private static int findAccountIndex(int accNo, Account[] accountArray, int ctr) {
		for (int i = 0; i <= ctr; i++) {
			if (accountArray[i].getAccountNumber() == accNo) {
				return i;
			}
		}
		return -1;
	}
}
