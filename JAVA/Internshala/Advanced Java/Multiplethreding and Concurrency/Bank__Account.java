//import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Bank__Account {
    private double balance;
    private final Lock lock=new ReentrantLock();

    public Bank__Account(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public void withdraw(double amount) {
        lock.lock();
        try{
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal");
        }
    }
    finally{
        lock.unlock();
    }
    }

    

    public void deposit(double amount) {
        lock.lock();
        try{
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    finally{
        lock.unlock();
    }
    }

    public double getBalance() {
        lock.lock();
        try{
            return balance;
        }
        finally{
            lock.unlock();
        }
    }
}