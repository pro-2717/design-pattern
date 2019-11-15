package keyouxing.interview.concurrent.sync;

/**
 * @author keyouxing
 */
public class JniThread {
    public static void main(String[] args){
        JniThread thread = new JniThread();
        thread.start0();

    }

    private native void start0();
}
