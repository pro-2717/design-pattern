package keyouxing.interview.concurrent.sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author keyouxing
 */
public class ObjectLayout {
  public static void main(String[] args) {
      CyclicBarrier cb = new CyclicBarrier(2,()->{
          System.out.println(3);
      });

      new Thread(()->{
          try {
              System.out.println("1");
              cb.await();

          } catch (InterruptedException e) {
              e.printStackTrace();
          } catch (BrokenBarrierException e) {
              e.printStackTrace();
          }
      }).start();

      try {
          System.out.println("2");
          cb.await();

      } catch (InterruptedException e) {
          e.printStackTrace();
      } catch (BrokenBarrierException e) {
          e.printStackTrace();
      }
  }
}
