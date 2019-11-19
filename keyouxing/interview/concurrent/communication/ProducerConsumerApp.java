package keyouxing.interview.concurrent.communication;

public class ProducerConsumerApp {
    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        new Thread(producerConsumer::produce, "producerThread-1").start();
        new Thread(producerConsumer::produce, "producerThread-2").start();
        new Thread(producerConsumer::produce, "producerThread-3").start();
        new Thread(producerConsumer::produce, "producerThread-4").start();

        new Thread(producerConsumer::consume, "consumerThread-1").start();
        new Thread(producerConsumer::consume, "consumerThread-2").start();
        new Thread(producerConsumer::consume, "consumerThread-3").start();
        new Thread(producerConsumer::consume, "consumerThread-4").start();
    }
}
