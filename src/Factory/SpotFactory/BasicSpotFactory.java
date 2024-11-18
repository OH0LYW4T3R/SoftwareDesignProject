package Factory.SpotFactory;

import Factory.Spot.BasicSpot;
import Factory.Spot.Spot;

public class BasicSpotFactory extends SpotFactory {
    public Spot createSpot(String storeName, Double latitude, Double longitude) {
        return new BasicSpot(storeName, latitude, longitude);
    }
}
