package keyouxing.designpattern.chain;

import java.util.function.Consumer;

/**
 * @author keyouxing
 */
public abstract class AbstractMessageHandler<R,T> implements MessageHandler<R,T>{

    Consumer<T> action;

    @Override
    public MessageHandler<R, T> complete(Consumer<T> action) {
        this.action = action;
        return this;
    }

    @Override
    public void receive(R r){
        check();
        parse(r);
    }

    abstract void parse(R r);

    protected void check(){
        if (action == null){
            System.out.println("解析器没有赋值");
        }
    }
}
