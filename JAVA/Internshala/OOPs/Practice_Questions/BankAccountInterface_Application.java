public class BankAccountInterface_Application {
    
    public static void main(String[] args) {
        
        SavingsAccountfromInterface s_account=new SavingsAccountfromInterface(10000.00);

        System.out.println();
        s_account.deposit(5000.00);
        System.out.println();
        s_account.withdraw(2000.00);
        System.out.println("\nBalance is: "+s_account.getBalance());
    }
}
