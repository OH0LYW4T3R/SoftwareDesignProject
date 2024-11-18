package Factory.SpotFactory;

import Factory.Spot.AttractionSpot;
import Factory.Spot.Spot;

public class AttractionSpotFactory extends SpotFactory {
    public Spot createSpot(String storeName, Double latitude, Double longitude) {
        return new AttractionSpot();
    }
}
