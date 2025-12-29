public class BankAccountApplication {

    public static void main(String[] args) {
        //TODO Auto-generated method stub

        /*BankAccount rbsAccount1 = new BankAccount(101,10000.00);
        //rbsAccount1.accountNumber = 101;
        //rbsAccount1.balance = 10000.00;
        System.out.println(rbsAccount1.getAccountNumber());
        rbsAccount1.deposit_amount(15000.00);
        rbsAccount1.withdra_amount(10000.00);
        rbsAccount1.check_balance();

        System.out.println();

        BankAccount rbsAccount2 = new BankAccount(201,50000.00);
        System.out.println(rbsAccount2.getAccountNumber());
        //rbsAccount2.accountNumber=201;
        //rbsAccount2.balance=50000.00;
        rbsAccount2.withdra_amount(5000.00);
        rbsAccount2.check_balance(); */

        System.out.println();
        BankAccount s_Account1=new SavingsAccount(301, 50000.00, 0.07);
        s_Account1.deposit_amount(10000.00);
        s_Account1.check_balance();
        s_Account1.calculateInterest();

      /* System.out.println();
        BankAccount account1=new BankAccount(401, 10000.00);
        BankAccount account2=new SavingsAccount(501, 20000.00, 0.07);
        account1.calculateInterest();//superclass interest will be invoked
        System.out.println();
        account2.calculateInterest();//subclass interest will be invoked */
    
        CurrentAccount c_account1=new CurrentAccount(601, 15000.00, 0.04);
        c_account1.calculateInterest();
        c_account1.check_balance();
    }
}
         