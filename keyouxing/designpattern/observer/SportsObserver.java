package keyouxing.designpattern.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SportsObserver implements WeatherObserver {
    Logger logger = LoggerFactory.getLogger(SportsObserver.class);
    @Override
    public void update(String weatherType) {
        switch (weatherType){
            case "sunny":
                logger.info("Today is sunny, so I can play football");
                break;
            case "rainy":
                logger.info("Today is rainy, so I only can stay at home and do my homework");
                break;
        }
    }
}
