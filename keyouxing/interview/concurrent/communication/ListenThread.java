package keyouxing.interview.concurrent.communication;

import java.util.ArrayList;
import java.util.List;

/**
 * One concurrent(FirstThread) put element into container, from one to ten,
 * Another concurrent(SecondThread) listens container,
 * when the size of container is 5, println("size is 5")
 * @author keyouxing
 */
public class ListenThread {

    private List<Integer> list = new ArrayList<>();

    private Object lock = new Object();

    public void put(){
        synchronized (lock){
            for (int i = 1; i <= 10; i++) {
                list.add(i);
                System.out.println("add: " + i);
                if(list.size()==5){
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void listen(){
        synchronized (lock){
            if(list.size() != 5){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("size is 5");
            lock.notify();
        }
    }

    public static void main(String[] args) {
        ListenThread container = new ListenThread();
        new Thread(container::put).start();
        new Thread(container::listen).start();
    }
}
