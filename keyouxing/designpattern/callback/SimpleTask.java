package keyouxing.designpattern.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SimpleTask implements Task{
    Logger logger = LoggerFactory.getLogger(SimpleTask.class);
    private Callback callback;

    public SimpleTask completeCallback(Callback callback){
        this.callback = callback;
        return this;
    }

    @Override
    public void execute() {
        logger.info("task is executing...");
        callback.call();
    }
}
