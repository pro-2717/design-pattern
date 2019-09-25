package keyouxing.observer;

import keyouxing.observer.WeatherObserver;

public class SportsObserver implements WeatherObserver {
    @Override
    public void update(String weatherType) {
        switch (weatherType){
            case "sunny":
                System.out.println("Today is sunny, so I can play football");
                break;
            case "rainy":
                System.out.println("Today is rainy, so I only can stay at home and do my homework");
                break;
        }

    }
}
