import java.util.LinkedList;
public class ProducerConsumerExample {
    
    public static void main(String[] args) {
        
        LinkedList<Integer> buffer= new LinkedList<>();

        Producer p= new Producer(buffer);
        Consumer c= new Consumer(buffer);

        Thread pthread = new Thread(p);
        Thread cthread = new Thread(c);

        //start
        pthread.start();
        cthread.start();

    }
}
