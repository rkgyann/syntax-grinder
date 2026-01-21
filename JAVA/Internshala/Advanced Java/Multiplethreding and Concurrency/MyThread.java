//package JAVA.Internshala.Advanced Java.Multiplethreding and Concurrency;


public class MyThread extends Thread{

    //override the run method
    @Override
    public void run(){
        //won logic
        //loop 1-5 create and generate thread
        for(int i=1;i<=5;i++){
            System.out.println("Thread: "+Thread.currentThread().getId()+" Count: "+i);

        }
    }
}
