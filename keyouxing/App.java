package keyouxing;

import keyouxing.designpattern.ReaderWriterLock.ReaderWriterLock;
import keyouxing.designpattern.ReaderWriterLock.Writer;
import keyouxing.designpattern.callback.SimpleTask;
import keyouxing.designpattern.observer.SellerObserver;
import keyouxing.designpattern.observer.SportsObserver;
import keyouxing.designpattern.observer.WeatherObserver;
import keyouxing.designpattern.observer.WeatherSubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class App {
    static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args){
//        testObserver();
//
//        System.out.println();
//
//        testCallback();
//
//        System.out.println();

        readerWriterLock();
    }

    private static void testObserver(){
        WeatherSubject subject = new WeatherSubject();

        WeatherObserver sellerObserver = new SellerObserver();
        WeatherObserver sportsObserver = new SportsObserver();

        subject.addWeatherObserver(sellerObserver);
        subject.addWeatherObserver(sportsObserver);

        subject.setWeather("sunny");
        subject.notifyWeatherObserver();

        subject.setWeather("rainy");
        subject.notifyWeatherObserver();
    }

    private static void testCallback(){
        SimpleTask task = new SimpleTask();
        task.completeCallback(() -> logger.info("The task execute completed")).execute();
    }

    private static void readerWriterLock() {
        ReaderWriterLock readerWriterLock = new ReaderWriterLock();
        ExecutorService executor = Executors.newFixedThreadPool(5);
//        ReaderWriterLock lock = new ReaderWriterLock();
        IntStream.range(0, 5).forEach(i -> executor.submit(new Writer("Writer "+ i, readerWriterLock.writeLock())));

    }
}
