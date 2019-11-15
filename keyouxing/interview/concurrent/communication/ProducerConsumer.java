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

    private volatile List<Integer> list = new ArrayList<>();
    private final static int BOUND = 30;
    private final static int CAPACITY = 10;
    private final static int EMPTY = 0;

    public synchronized void produce(){
        while(list.size() == CAPACITY){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int product = (new Random()).nextInt(BOUND);
        list.add(product);
        System.out.println(Thread.currentThread().getName() + " produce: " + product);
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
        int product = list.remove(0);
        System.out.println(Thread.currentThread().getName() + " consume: " + product);
        notifyAll();
    }

}
