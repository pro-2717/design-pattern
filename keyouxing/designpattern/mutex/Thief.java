package keyouxing.designpattern.mutex;

/**
 * @author keyouxing
 */
public class Thief{

  private final Jar jar;

  private String name;

  public Thief(String name, Jar jar){
    this.jar = jar;
    this.name = name;
  }

  public void steal() {
    int beans = 0;
    while (jar.takeBean()){
      beans++;
      System.out.println(name+ " stole a bean");
    }
    System.out.println(name+ " stole beans:" + beans);
  }
}
