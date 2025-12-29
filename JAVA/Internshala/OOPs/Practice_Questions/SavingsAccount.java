public class SavingsAccount extends BankAccount {
    
    //inherited attributes/methods
    
    //attributes
    private double interestRate=0.07;

    public SavingsAccount(int accountNumber, double balance, double interestRate){
        
        //suoer->keyword
        super(accountNumber,balance);
        this.interestRate=interestRate;
    }

    //methods->calculate interest
    @Override
    public void calculateInterest(){
        double interest= getBalance()* interestRate;
        deposit_amount(interest);
        System.out.println("Interest Added: "+interest);
        System.out.println("Savings Account Interest: "+getAccountNumber());
    }
}
