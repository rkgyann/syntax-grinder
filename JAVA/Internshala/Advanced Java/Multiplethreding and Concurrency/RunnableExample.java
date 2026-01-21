//package JAVA.Internshala.Advanced Java.Multiplethreding and Concurrency;

public class RunnableExample {
    
    public static void main(String[] args) {
        
        MyRunnable runnableobj=new MyRunnable();
        //create a thread
        Thread thread1= new Thread(runnableobj);
        Thread thread2= new Thread(runnableobj);

        //start
        thread1.start();
        thread2.start();
    }
}
