package keyouxing.designpattern.ReaderWriterLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;

public class Writer implements Runnable{
    Logger logger = LoggerFactory.getLogger(Writer.class);

    private String name;

    private Lock lock;

    public Writer(String name, Lock lock ) {
        this.name = name;
        this.lock = lock;
    }


    @Override
    public void run() {
        lock.lock();

        try {
            write();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.unlock();
    }

    private void write() throws InterruptedException {
        logger.info("{} starts writing", name);
        Thread.currentThread().sleep(1000);
        logger.info("{} completes writing", name);
    }
}
