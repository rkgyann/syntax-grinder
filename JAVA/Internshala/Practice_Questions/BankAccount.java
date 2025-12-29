public abstract class BankAccount {
    // Attributes
    private int accountNumber;
    private double balance;

    // constructor
    public BankAccount(int accountNumber, double initialBalance) {
        // key-> this-> particular object
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    //Getters
    public int getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    //Setters
    public void setAccountNumber(int accountNumber){
        this.accountNumber=accountNumber;
    }

    public void setBalance(double balance){
        this.balance=balance;
    }

    // methods
    public void deposit_amount(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount Deposited. \nNew Balance: " + balance);
        } else
            System.out.println("Invalid Amount");

    }

    public void withdra_amount(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawl Done. \nNew Balance: " + balance);
        } else
            System.out.println("Invalid Amount");
    }

    public void check_balance() {
        System.out.println("Your Balance: " + balance);
    }

    //cal-interest->5%
    public abstract void calculateInterest(); /*{
        double interest=0.05;
        double interestAdded=getBalance()*interest;
        deposit_amount(interestAdded);
        System.out.println("Added Interest: "+interestAdded);
        System.out.println("Bank Account Interest: "+getAccountNumber());
    }*/
}
