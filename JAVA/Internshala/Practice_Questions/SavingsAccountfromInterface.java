public class SavingsAccountfromInterface implements BankAccountInterface{

    private double balance;
    public SavingsAccountfromInterface(double initialBalance){
        balance= initialBalance;
    }
    @Override
    public void deposit(double amount){

        if(amount>0){
            balance+=amount;
            System.out.println("Deposited Amount: "+amount);
            System.out.println("New Balance: "+balance);
        }
        else 
            System.out.println("Invalid Deposit"); 
    }

    @Override
    public void withdraw(double amount){
        
        if(amount>0 && amount<=balance){
            balance-=amount;
            System.out.println("Withdrawn Amount: "+amount);
            System.out.println("New Balance: "+balance);
        }
        else 
            System.out.println("Invalid Withdrawal Account or Insufficient Balance. "); 
    }

    @Override
    public double getBalance(){
        return balance;
    }
}
