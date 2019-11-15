package keyouxing.interview.concurrent.communication;

public class ProducerConsumerApp {
    public static void main(String[] args) {
        new Thread((new ProducerConsumer())::produce, "producerThread-1").start();
        new Thread((new ProducerConsumer())::produce, "producerThread-2").start();

        new Thread((new ProducerConsumer())::consume, "consumerThread-1").start();
        new Thread((new ProducerConsumer())::consume, "consumerThread-2").start();
        new Thread((new ProducerConsumer())::consume, "consumerThread-3").start();
        new Thread((new ProducerConsumer())::consume, "consumerThread-4").start();
    }
}
