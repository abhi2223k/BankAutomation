//Jayesh Kardile
package bank;

public class Report {
    double accountNumber;
    String process;
     double bankBalance;

    public Report(double number, String process, double bankBalance) {
        this.accountNumber = number;
        this.process = process;
        this.bankBalance = bankBalance;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public void endDayOfReport() {
        System.out.println(this.getAccountNumber() + "\t|\t" + this.getProcess() + "\t|\t" + this.getBankBalance());
    }
}
