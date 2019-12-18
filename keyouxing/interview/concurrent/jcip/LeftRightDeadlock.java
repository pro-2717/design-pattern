package keyouxing.interview.concurrent.jcip;

/**
 * @author keyouxing
 */
public class LeftRightDeadlock {
  private final Object leftLock = new Object();
  private final Object rightLock = new Object();

  public void rightLock() {
    synchronized (rightLock){
      synchronized (leftLock){
        doSomething();
      }
    }
  }

  public void leftLock() {
    synchronized (leftLock){
      synchronized (rightLock){
        doSomething();
      }
    }
  }

  private void doSomething() {
  }
}
