package keyouxing.interview.concurrent.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author keyouxing
 */
public class ObjectLayout {

    private static Demo demo = new Demo();
    private void lock(){
        synchronized (demo){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ClassLayout.parseInstance(demo).toPrintable());
        }
    }
    public static void main(String[] args){

        ObjectLayout layout = new ObjectLayout();
        layout.lock();
        layout.lock();

    }

}
