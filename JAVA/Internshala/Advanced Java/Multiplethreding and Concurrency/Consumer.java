import java.util.LinkedList;
public class Consumer implements Runnable{

    //buffer, constructor, run
    private final LinkedList<Integer> buffer;

    Consumer(LinkedList<Integer> buffer){
        this.buffer= buffer;

    }

    @Override
    public void run(){
        //infinite 
        while (true) {
            try{
                this.consume();
            }
            catch(Exception e){
                System.out.println(e);
            }     
        }
    }

    public void consume() throws InterruptedException{
        synchronized(buffer){
            //buffer- empty
            while (buffer.size()==0) {
                System.out.println("Consumer is waiting.");
                buffer.wait();
            }

            //consume
            int num=buffer.remove(0);
            System.out.println("Consumer has Consumed: "+num);
            buffer.notifyAll();
            Thread.sleep(5);
        }
    }
}
