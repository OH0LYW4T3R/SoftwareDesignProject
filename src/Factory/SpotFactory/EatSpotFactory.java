package Factory.SpotFactory;

import Factory.Spot.RestSpot;
import Factory.Spot.Spot;
import Factory.Spot.SpotFlag;

public class EatSpotFactory extends SpotFactory {
    public Spot createSpot(String provider, String storeName, String address) {
        Spot spot = new RestSpot(provider, storeName, address);
        spot.setSpotFlag(SpotFlag.EAT);
        return spot;
    }
}
