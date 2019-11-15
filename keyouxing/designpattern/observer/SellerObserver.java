package keyouxing.designpattern.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SellerObserver implements WeatherObserver {
    Logger logger = LoggerFactory.getLogger(SellerObserver.class);
    @Override
    public void update(String weatherType) {
        switch (weatherType){
            case "sunny":
                logger.info("Today is sunny, so I need to sell my sunscreen");
                break;
            case "rainy":
                logger.info("Today is rainy, so I need to sell my umbrella");
                break;
        }

    }

}
