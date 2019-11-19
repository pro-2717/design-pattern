package keyouxing.designpattern.mutex;

/**
 * @author keyouxing
 */
public class App {
  public static void main(String[] args) {
    Mutex mutex = new Mutex();
    Jar jar = new Jar(500, mutex);
    Thief tom = new Thief("tom", jar);
    Thief jerry = new Thief("jerry", jar);
    new Thread(jerry::steal).start();
    new Thread(tom::steal).start();
  }
}
