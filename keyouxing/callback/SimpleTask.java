package keyouxing.callback;

public class SimpleTask implements Task{

    private Callback callback;

    public SimpleTask completeCallback(Callback callback){
        this.callback = callback;
        return this;
    }

    @Override
    public void execute() {
        System.out.println("task is executing...");
        callback.call();
    }
}
