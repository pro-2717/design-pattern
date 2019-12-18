package keyouxing.interview.concurrent.communication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * One concurrent put element into container, from one to ten,
 * Another concurrent listens container, when the size of container is 5, println("size is 5")
 * @author keyouxing
 */
public class CountDown {
    private CountDownLatch latch = new CountDownLatch(1);

    private List<Integer> list = new ArrayList<>();

    private int capacity = 10;

    private Object lock = new Object();

    private int latchKey = 5;

    public void put(){

        for (int i = 1; i <= capacity; i++) {
            list.add(i);
            System.out.println("add: " + i);
            if(list.size() == latchKey){
                latch.countDown();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void listen(){

        if(list.size() != latchKey){
            try {
                latch.await();
                System.out.println("size is 5");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {
        CountDown container = new CountDown();
        new Thread(container::put).start();
        new Thread(container::listen).start();
    }

}
