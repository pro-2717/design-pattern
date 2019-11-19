package keyouxing.designpattern.mutex;

/**
 * @author keyouxing
 */
public class Jar {

  private int beans;

  private Lock lock;

  public Jar(int beans, Lock lock){
    this.beans = beans;
    this.lock = lock;
  }

  public boolean takeBean(){
    boolean success = false;
    try {
      lock.lock();
      success = beans > 0;
      if (success) {
        beans--;
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally{
      lock.release();
    }
    return success;
  }

}
