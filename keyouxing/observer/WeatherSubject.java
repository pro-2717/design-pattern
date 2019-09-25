package keyouxing.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherSubject {

    private String weather;

    public void setWeather(String weather){
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
