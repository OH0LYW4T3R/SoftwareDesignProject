package Factory.SpotFactory;

import Factory.Spot.BasicSpot;
import Factory.Spot.RestSpot;
import Factory.Spot.Spot;

public class RestSpotFactory extends SpotFactory {
    public Spot createSpot(String storeName, Double latitude, Double longitude) {
        return new RestSpot();
    }
}
