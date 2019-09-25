package keyouxing;

import keyouxing.callback.SimpleTask;
import keyouxing.callback.Task;
import keyouxing.observer.SellerObserver;
import keyouxing.observer.SportsObserver;
import keyouxing.observer.WeatherObserver;
import keyouxing.observer.WeatherSubject;

public class App {
    public static void main(String[] args){

        testObserver();

        testCallback();

    }

    private static void testObserver(){
        WeatherSubject subject = new WeatherSubject();

        WeatherObserver sellerObserver = new SellerObserver();
        WeatherObserver sportsObserver = new SportsObserver();

        subject.addWeatherObserver(sellerObserver);
        subject.addWeatherObserver(sportsObserver);

        System.out.println("set weather: sunny\n");
        subject.setWeather("sunny");
        subject.notifyWeatherObserver();

        System.out.println("\nreset weather: rainy\n");
        subject.setWeather("rainy");
        subject.notifyWeatherObserver();
    }

    private static void testCallback(){
        SimpleTask task = new SimpleTask();
        task.completeCallback(() -> { System.out.println("The task execute completed"); }).execute();
    }
}
