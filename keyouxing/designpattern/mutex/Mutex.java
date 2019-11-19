package keyouxing.designpattern.mutex;

/**
 * @author keyouxing
 */
public class Mutex implements Lock{

    private Object owner;
    @Override
    public synchronized void lock() throws InterruptedException {
        while (owner != null) {
            wait();
        }
        owner = Thread.currentThread();
    }
    @Override
    public synchronized void release() {
        if (Thread.currentThread() == owner) {
            owner = null;
            notifyAll();
        }

    }
}
