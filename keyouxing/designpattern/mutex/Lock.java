package keyouxing.designpattern.mutex;

/**
 * @author keyouxing
 */
public interface Lock {

    /**
     * 加锁
     */
    public void lock() throws InterruptedException;

    /**
     * 解锁
     */
    public void release();
}
