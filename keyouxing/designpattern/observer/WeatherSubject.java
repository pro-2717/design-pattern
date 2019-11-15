package keyouxing.designpattern.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class WeatherSubject {
    Logger logger = LoggerFactory.getLogger(WeatherSubject.class);
    private String weather;

    public void setWeather(String weather){
        logger.info("set weather: {}", weather);
        this.weather = weather;
    }

    List<WeatherObserver> observers = new ArrayList<>();

    public void addWeatherObserver(WeatherObserver observer){
        observers.add(observer);
    }

    public void removeWeatherObserver(WeatherObserver observer){
        observers.remove(observer);
    }

    public void notifyWeatherObserver(){
        for (WeatherObserver observer: observers){
            observer.update(weather);
        }
    }
}
