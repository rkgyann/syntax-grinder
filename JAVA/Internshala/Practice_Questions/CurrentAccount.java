public class CurrentAccount extends BankAccount{
    
    private double interestRate;

    public CurrentAccount(int accountNumber, double balance, double interestRate){
        super(accountNumber, balance);
        this.interestRate=interestRate;
        System.out.println();
    }

    @Override
    public void calculateInterest(){
        double interest= getBalance()*interestRate;
        deposit_amount(interest);
        System.out.println("Current Account Interest: "+super.getAccountNumber());
        System.out.println("Interest Added: "+interest);
    }
}
