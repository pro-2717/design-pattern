package keyouxing.interview.concurrent.communication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * two threads produce product
 * ten threads consume product
 * @author keyouxing
 */
public class ProducerConsumer {

    private List<Integer> list = new ArrayList<>();
    private final static int BOUND = 10;
    private final static int CAPACITY = 10;
    private final static int EMPTY = 0;
    private boolean available;

    public synchronized void produce(){
        while(list.size() == CAPACITY){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add((new Random()).nextInt(BOUND));
        available = true;
        notifyAll();
    }

    public synchronized void consume(){
        while(list.size() == EMPTY){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.remove(0);
        available = false;
        notifyAll();
    }

}
