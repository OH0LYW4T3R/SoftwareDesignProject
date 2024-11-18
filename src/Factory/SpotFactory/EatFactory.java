package Factory.SpotFactory;

import Factory.Spot.EatSpot;
import Factory.Spot.Spot;

public class EatFactory extends SpotFactory {
    public Spot createSpot(String storeName, Double latitude, Double longitude) {
        return new EatSpot();
    }
}
