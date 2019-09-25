package keyouxing.observer;

import keyouxing.observer.WeatherObserver;

public class SellerObserver implements WeatherObserver {
    @Override
    public void update(String weatherType) {
        switch (weatherType){
            case "sunny":
                System.out.println("Today is sunny, so I need to sell my sunscreen");
                break;
            case "rainy":
                System.out.println("Today is rainy, so I need to sell my umbrella");
                break;
        }

    }

}
