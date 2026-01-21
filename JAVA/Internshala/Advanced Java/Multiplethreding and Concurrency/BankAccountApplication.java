//package JAVA.Internshala.Advanced Java.Multiplethreding and Concurrency;

public class BankAccountApplication {
    
    public static void main(String[] args) {
        
        //shared account
        Bank__Account account= new Bank__Account(10000.00);

        //multiple threads
        Thread withdrawThread= new Thread(() -> { account.withdraw(2000.00);});
        Thread depositThread= new Thread(() -> { account.deposit(5000.00);});
        Thread balanceThread= new Thread(() -> {double balance = account.getBalance(); System.out.println("Current Balance is: "+balance);});

        //start
        withdrawThread.start();
        depositThread.start();
        balanceThread.start();
    }
}
