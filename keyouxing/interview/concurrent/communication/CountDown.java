package keyouxing.interview.concurrent.communication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * One concurrent(FirstThread) put element into container, from one to ten,
 * Another concurrent(SecondThread) listens container,
 * when the size of container is 5, println("size is 5")
 * @author keyouxing
 */
public class CountDown {
    CountDownLatch latch = new CountDownLatch(1);

    private List<Integer> list = new ArrayList<>();

    private Object lock = new Object();

    public void put(){

        for (int i = 1; i <= 10; i++) {
            list.add(i);
            System.out.println("add: " + i);
            if(list.size()==5){
                latch.countDown();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void listen(){

        if(list.size() != 5){
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
