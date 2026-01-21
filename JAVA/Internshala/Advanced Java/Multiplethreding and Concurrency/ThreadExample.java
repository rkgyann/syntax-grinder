//package JAVA.Internshala.Advanced Java.Multiplethreding and Concurrency;

public class ThreadExample {
    
    public static void main(String[] args) {
        
        MyThread thread1= new MyThread();
        MyThread thread2=new MyThread();

        //start the thread
        thread1.start();
        thread2.start();
    }
}
