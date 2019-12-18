package keyouxing.designpattern.chain;

import java.util.function.Consumer;

/**
 * @author keyouxing
 */
public interface MessageHandler<R,T> {

    /**
     * 接受数据的方法
     * @param r 接受到的数据类型
     */
    void receive(R r);

    /**
     * @param action 就收数据完成后回调的方法
     * @return return this
     */
    MessageHandler<R,T> complete(Consumer<T> action);
}
